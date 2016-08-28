/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Operaciones;

/**
*
* @author Anthony Hernandez
*/

import Objetos.Objeto;
import Ventanas.Estudiante;

import java.util.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;

import org.xml.sax.SAXException;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class Operaciones extends Conexion{
    /**
     * Constructor for objects of class Operaciones
     */
    public Operaciones(){}
    
    public boolean insertar(String sql){
        boolean valor = true;
        conectar();
        try {
        	consulta.executeUpdate(sql);
            
        } catch (SQLException e) {
                valor = false;
                
            }      
        finally{  
            try{    
                 consulta.close();  
                 conexion.close();  
             }catch (Exception e){                 
                 e.printStackTrace();  
             }  
        }
        return valor;
    }
    public ResultSet consultar(String sql){
        conectar();
        ResultSet resultado = null;
        try {
            resultado = consulta.executeQuery(sql);

        } catch (SQLException e) {
                System.out.println("Mensaje:"+e.getMessage());
                System.out.println("Estado:"+e.getSQLState());
                System.out.println("Codigo del error:"+e.getErrorCode());
                JOptionPane.showMessageDialog(null, ""+e.getMessage());
            }
        return resultado;
    }

    public void guardarUsuario(Objeto Objeto){  
    	insertar("insert into Objeto values("+Objeto.getMatricula()+",'"+Objeto.getNombre()+"','"+Objeto.getDireccion()+"','"+Objeto.getCiudad()+"',"+Objeto.getEdad()+")");
    } 
  
    public void totalObjetos(DefaultTableModel tableModel){
        ResultSet resultado = null;
        tableModel.setRowCount(0);
        tableModel.setColumnCount(0);
        String sql = "select * from Objeto";
        try {
            resultado = consultar(sql);
            if(resultado != null){
                int numeroColumna = resultado.getMetaData().getColumnCount();
                for(int j = 1;j <= numeroColumna;j++){
                    tableModel.addColumn(resultado.getMetaData().getColumnName(j));
                }
                while(resultado.next()){
                    Object []objetos = new Object[numeroColumna];
                    for(int i = 1;i <= numeroColumna;i++){
                        objetos[i-1] = resultado.getObject(i);
                    }
                    tableModel.addRow(objetos);
                }
            }
        }catch(SQLException e){
        }

        finally
     {
         try
         {
             consulta.close();
             conexion.close();
             if(resultado != null){
                resultado.close();
             }
         }
         catch (Exception e)
         {
             e.printStackTrace();
         }
     }
    }
    
    public void consultar1(String id_1){
        ResultSet resultado = null;
        
        String sql = "select * from Objeto where matricula=";
        try {
            resultado = consultar(sql+id_1);
            
                while(resultado.next()){
                	 JOptionPane.showMessageDialog(null,("Matricula -> " 
                + resultado.getString("matricula")+"\n"
                +("Nombre -> " + resultado.getString("nombre")+"\n"
                +("Direccion -> " + resultado.getString("direccion")+"\n"
                +("Ciudad -> " + resultado.getString("ciudad")+"\n"
                +("Edad -> " + resultado.getInt("edad")))))));
                    
                }
            
        }catch(SQLException e){
        }

        finally
     {
         try
         {
             consulta.close();
             conexion.close();
             if(resultado != null){
                resultado.close();
             }
         }
         catch (Exception e)
         {
             e.printStackTrace();
         }
     }
    }
    
    
	public boolean validar(int id){
        
        ResultSet resultado = null;
        conectar();
        try {
            resultado = consultar("select * from Objeto where matricula="+id);
        	
        	 while(resultado.next()){
        		 if(id==resultado.getInt("matricula")){
        			 return true;
        		 }
        		 else
        			 return false; 
        	 }
            
        } catch (SQLException e) {                
            }      
        finally{  
            try{    
                 consulta.close();  
                 conexion.close(); 
                 if(resultado != null){
                     resultado.close();
                  }
             }catch (Exception e){                 
                 e.printStackTrace();  
             }  
        }
		return false;
        
    }
	BufferedReader in;
	 StreamResult out;
	 TransformerHandler th;
	
	public void xml() throws TransformerConfigurationException, ParserConfigurationException, SAXException{
       ResultSet resultado = null;
       
       String sql = "select * from Objeto";
		String matricula = null,nombre=null,direccion=null,ciudad=null,edad=null;
		
		out = new StreamResult("file.xml");
       openXml();
       try {
           resultado = consultar(sql);
           
               while(resultado.next()){
                   
                   matricula = ""+resultado.getInt("matricula");
                   nombre=resultado.getString("nombre");
                   direccion=resultado.getString("direccion");
                   ciudad=resultado.getString("ciudad");
                   edad=""+resultado.getInt("edad");
                   procesar_txt(matricula,nombre,direccion,ciudad,edad);      
               }
              	
               cerrarEtiqueta();
       }catch(SQLException e){
       }

       finally
    {
        try
        {
            consulta.close();
            conexion.close();
            if(resultado != null){
               resultado.close();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
   }
	
	
	
	

  public void openXml() throws ParserConfigurationException, TransformerConfigurationException, SAXException {

      SAXTransformerFactory tf = (SAXTransformerFactory) SAXTransformerFactory.newInstance();
      th = tf.newTransformerHandler();

      Transformer txt = th.getTransformer();
      txt.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
      txt.setOutputProperty(OutputKeys.INDENT, "yes");

      th.setResult(out);
      th.startDocument();
      th.startElement(null, null, "list", null);
  }

  public void procesar_txt(String mat,String nom,String mate,String n_p,String n_e) throws SAXException {
  	th.startElement(null, null, "Alumno", null);
  	th.startElement(null, null, "matricula", null);
      th.characters(mat.toCharArray(), 0, mat.length());
      th.endElement(null, null, "matricula");
      th.startElement(null, null, "nombres", null);
      th.characters(nom.toCharArray(), 0, nom.length());
      th.endElement(null, null, "nombres");
      th.startElement(null, null, "direccion", null);
      th.characters(mate.toCharArray(), 0, mate.length());
      th.endElement(null, null, "direccion");
      th.startElement(null, null, "ciudad", null);
      th.characters(n_p.toCharArray(), 0, n_p.length());
      th.endElement(null, null, "ciudad");
      th.startElement(null, null, "edad", null);
      th.characters(n_e.toCharArray(), 0, n_e.length());
      th.endElement(null, null, "edad");
      th.endElement(null, null, "Alumno");
      

  }

  public void cerrarEtiqueta() throws SAXException {
      th.endElement(null, null, "list");
      th.endDocument();


  }
}