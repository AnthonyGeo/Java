/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rec;

/**
 *
 * @author Cristhian
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class Rec {
    
    static Archivo txt= new Archivo();
    static Alumno alumno ;
    static Lista list = new Lista();
    static Alumno e = new Alumno();
    static File archivo = new File("Estudiantes.txt");
    static toXML xml = new toXML();
    static toJSON json = new toJSON();
    
    
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        int a; 
        iniciar();
		
            do{
                a=Integer.parseInt(JOptionPane.showInputDialog("OP1: Ingresar alumno"+"\n"+"OP2: Listar Alumnos"+"\n"+"OP3: Buscar alumno"+"\n"+"OP4: Editar alumno"+"\n"+"OP5: Mostar aprobados"+"\n"+"OP6: Guardar"+"\n"+"OP7: Exportar a XML"+"\n"+"OP8: Exportar JSON"+"\n"+"OP9: Exportar de XML a TXT"+"\n"+"OP10: Salir"));
            switch(a)
            {
               //***a************ IMGRESO DE ALUMNOS ******************+**
               case 1:
                    alumno = new Alumno(Integer.parseInt(JOptionPane.showInputDialog("Ingrese su matricula: ")),JOptionPane.showInputDialog("Ingrese su nombre: "),JOptionPane.showInputDialog("Ingrese la materia: "),Double.parseDouble(JOptionPane.showInputDialog("Ingrese la nota total: ")),Double.parseDouble(JOptionPane.showInputDialog("Ingrese la nota del examen: ")));
                    list.añadir(alumno);
               break;
                       
                       //*************** MUESTRA LISTA DE ALUMNOS ******************+**
               case 2:   
                   list.mostrar();
               break;
                   
               case 3:
                   e = list.buscar(Integer.parseInt(JOptionPane.showInputDialog("Ingrese matricula")));
            	   if(e!= null){
            		   e.info();
            	   }else{
            		   JOptionPane.showMessageDialog(null, "No existe registro");
            	   }
                   break;
                   
                   //***************ESTUDIANTE MODIFICADO ************
                   
               case 4:
                   int option;
            	   e = list.buscar(Integer.parseInt(JOptionPane.showInputDialog("Ingrese matricula")));
            	   
            	   if(e!= null){
            		   do{
            	    option = Integer.parseInt(JOptionPane.showInputDialog("Ingrese Opcion de elemento a modificar"
            	   		+ "\n1) Materia\n"
            	   		+ "2)Nombre\n"
            	   		+ "3) Nota Parcial\n"
            	   		+ "4) Nota Examen "
            	   		+ "\n5) Regresar"));
            	   
            	   switch(option){
            	   
            	   case 1:
            		   e.setMateria(JOptionPane.showInputDialog("Ingrese Materia"));
            		   JOptionPane.showMessageDialog(null, "Estudiante Modificado");
            		   break;
            		   
            	   case 2:
            		   e.setNombre(JOptionPane.showInputDialog("Ingrese Nombre"));
            		   JOptionPane.showMessageDialog(null, "Estudiante Modificado");
            		   break;
            	   case 3:	  
            		  e.setNota_total(Double.parseDouble(JOptionPane.showInputDialog("Ingrese Nota parcial")));
            		  JOptionPane.showMessageDialog(null, "Estudiante Modificado");
            		  break;
            		  
            	   case 4:
            		  e.setNota_exa(Double.parseDouble(JOptionPane.showInputDialog("Ingrese nota examen")));
            		  JOptionPane.showMessageDialog(null, "Estudiante Modificado");
            		  break;
            		 
            		  	   
            	   }
            	   }while(option != 5);
            	   }else
            		   JOptionPane.showMessageDialog(null, "Estudiante No existe");
            	   break;
                   
                   // ******************* MUESTRA APROBADOS ********************** 
                   
               case 5:
                   System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-**-*-*-*-*-*-*-APROBADOS-*-*-*-*-*-*-*-*-**-*-*-*-*-*-*-*-*-*-*-");
                   list.mostrar_aprobados();
                   break;
                   
               case 6:
                   txt.crear(list.lista(),archivo);
                   JOptionPane.showMessageDialog(null,"INFORMACION GUARDADA CON EXITO","AVISO",JOptionPane.WARNING_MESSAGE);
               break;
                   
               case 7: 
                   xml.creacion();
                   JOptionPane.showMessageDialog(null,"ARCHIVO EXPORTADO CON EXITO","AVISO",JOptionPane.WARNING_MESSAGE);
                   break;
               case 8: 
                   //json.getXMLfromJson();
                   JOptionPane.showMessageDialog(null,"ARCHIVO EXPORTADO CON EXITO","AVISO",JOptionPane.WARNING_MESSAGE);
                   break;
               case 10:
            	   JOptionPane.showMessageDialog(null, "SALIENDO...!");
            }
            
            	   
             
            }while(a!= 10);
    }
    
    static public  void iniciar() throws ClassNotFoundException, IOException
    {
        alumno = new Alumno(9091,"Cedeno Karol","Ecuaciones",12,10.5);
        list.añadir(alumno);
	alumno = new Alumno(9092,"Bautista Jennifer","Geometria",10,10.5);
        list.añadir(alumno);
	alumno = new Alumno(9093,"Pancracio Estacio","Aritmetica",24,10.5);
        list.añadir(alumno);
        
        try {
            
            if (archivo.exists())
            {
                list.limpiarArrayList();
                LecturaFichero();
            }
            else if(archivo.createNewFile())
                txt.crear(list.lista(),archivo);
            } catch (IOException ioe) {
                ioe.printStackTrace();
          }
    }
    
    static public void LecturaFichero()throws IOException, ClassNotFoundException
    {
        try(BufferedReader br = new BufferedReader (new FileReader(archivo)))
            {
                String linea;
                while((linea=br.readLine())!=null)
                {
                    String matricula="";
                    String nombre="";
                    String genero = "";
                    String nota_total="";
                    String nota_exa="";
                    
                    for (int x=0,co=0;x<linea.length();x++)
                    {
                        if(linea.charAt(x)!= ',')
                        {
                            if(co==0)
                                genero= genero + String.valueOf(linea.charAt(x));
                            else if(co==1)
                                matricula=matricula + String.valueOf(linea.charAt(x));
                            else if(co==2)
                                nombre=nombre + String.valueOf(linea.charAt(x));
                            else if(co==3)
                                nota_total=nota_total + String.valueOf(linea.charAt(x));
                            else 
                                nota_exa = nota_exa + String.valueOf(linea.charAt(x)); 
                        }
                        else
                            co++;
                    }
                    alumno = new Alumno(Integer.parseInt(matricula),nombre,genero,Double.parseDouble(nota_total),Double.parseDouble(nota_exa));
                    list.añadir(alumno);
                }
            }
            catch(IOException e)
            { 
                JOptionPane.showMessageDialog(null, "Error de Lectura del archivo");
            } 
    }
}
