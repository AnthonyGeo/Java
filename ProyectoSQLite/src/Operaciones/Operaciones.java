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
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

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
    	insertar("insert into Objeto values("+Objeto.getId()
                    +",'"+Objeto.getnombre()
                    +"',"+Objeto.getStock()
                    +",'"+Objeto.getFecha()+"')");
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
        
        String sql = "select * from Objeto where id=";
        try {
            resultado = consultar(sql+id_1);
            
                while(resultado.next()){
                	 JOptionPane.showMessageDialog(null,("Nombre = " + resultado.getString("nombre")+"\n"+("Id = " + resultado.getInt("id")+"\n"+("Stock = " + resultado.getInt("stock")+"\n"+("Fecha = " + resultado.getString("fecha"))))));
                    
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
            resultado = consultar("select * from Objeto where id="+id);
        	
        	 while(resultado.next()){
        		 if(id==resultado.getInt("id")){
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
    
}