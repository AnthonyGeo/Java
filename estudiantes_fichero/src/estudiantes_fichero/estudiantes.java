package estudiantes_fichero;

import java.io.FileReader;   
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;  
import javax.swing.JOptionPane; 
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.File;

import javax.xml.bind.Element;
import javax.xml.parsers.*;
import javax.xml.soap.Text;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
public class estudiantes  {
	public  String matricula; 
	public  String nombres; 
	public  String materia; 
	public  float nota_parcial;
	public  float exa;
	public  float aux; 
	public  float prom; 
	public estudiantes(String nombres,String matricula,String materia,float nota_parcial,float exa){
		this.nombres=nombres;
		this.matricula=matricula;
		this.materia=materia;
		this.nota_parcial=nota_parcial;
		this.exa=exa; 
	}
	
	public estudiantes() {
	}

	public void menu() throws IOException{
		int op ;
		String nuevo = null;
		do{
		op = Integer.parseInt(JOptionPane.showInputDialog("OP 1: Ingresar estudiante "+"\n"+"OP 2: Listar Estudiantes"+"\n"+"OP 3: Buscar estudiante por matricula"+"\n"+"OP 4: Editar informacion de estudiante"+"\n"+"OP 5: Mostrar estudiantes que aprueban"+"\n"+"OP 6: Guardar informacion"+"\n"+"OP 7: Exportar informacion a XML"+"\n"+"OP 8: Salir"));
		switch (op){
		case 1:
		nuevo=ingresar_estudiante(); 
		break; 
		case 2:
		System.out.println("-----------------------------------------------LISTADO DE ESTUDIANTES--------------------------------------------");
		lectura_fichero(); 
		break;
		case 3:
		buscar_estudiantes(); 
		break;
		case 4:
		editar();
		break;
		case 5:
		System.out.println("-----------------------------------------------LISTADO DE ESTUDIANTES APROBADOS--------------------------------------------");
		estudiantes_aprobados(); 	
		break; 
		case 6:
		if(nuevo!=null){
		guardar(nuevo);
		JOptionPane.showMessageDialog(null, "INFORMACION GUARDADA CON EXITO","ATENCION",JOptionPane.WARNING_MESSAGE); 
		nuevo=null;}
		else
			JOptionPane.showMessageDialog(null, "NO SE A INGRESADO INFORMACION NUEVA","ERROR",JOptionPane.ERROR_MESSAGE);
		break;
		case 7:
		break;
		case 8:
		break;
		}
		}while(op!=8);
	
	}
	
    //Mostrar Estudiantes
	public void mostrar(){
		System.out.println("Nombre: "+this.nombres+" | Matricula: "+this.matricula+" | Materia: "+this.materia+" | Nota parcial: "+this.nota_parcial+" | Nota examen: "+this.exa); 
		
	}
    
	// Lee el fichero
	public void lectura_fichero()throws IOException{
		int aux=0; 
		try{
			String ruta;
			ruta = main.class.getResource("estudiante.txt").toString();
			String ruta2=ruta.substring(6, ruta.length());
			BufferedReader read = new BufferedReader(new FileReader(ruta2));
			String line; 
			while ((line=read.readLine())!= null){  
				aux++; 
				lectura_estudiantes(line, aux); 
				mostrar(); 
			}
			}catch(FileNotFoundException e){
				JOptionPane.showMessageDialog(null, "NO EXISTE","ATENCION",JOptionPane.WARNING_MESSAGE);
			}
	}
	
	//Hace el recorrido linea a linea y va guardando los datos en las distintas variables de instancia
	public void lectura_estudiantes(String line, int aux){
		int pos=0;
		for (int x=aux-1; x<aux;x++){
			pos=0;
		for (int i=0; i<line.length();i++){
	    	  if(line.substring(i,i+1).equals(" ")){
	    		  pos++; 
	    		  if(pos==2){
	    			  this.nombres=(line.substring(0,i));
	    		  }
	    		  if(pos==3){
	    			  this.matricula=(line.substring(this.nombres.length()+1,i)); 
	    		  }
	    		  if(pos==4){
	    			  this.materia=(line.substring(this.matricula.length()+this.nombres.length()+1,i)); 
	    		  }
	    		  if(pos==5){
	    			  this.nota_parcial=(Float.parseFloat(line.substring(this.materia.length()+this.matricula.length()+this.nombres.length()+1,i))); 
	    		  }
	    		  if(pos==6){
	    			  this.exa= (Float.parseFloat(line.substring(Float.toString(this.nota_parcial).length()+this.materia.length()+this.matricula.length()+this.nombres.length()+2))); 
	    		  } 
	    	  }
		}
		 
		}
	}
	
    //Compara la matricula ingresada y en caso de ser V lo muestra
	public void buscar(String mat){ 
		if (mat.equals(this.matricula)){
		System.out.println("-------------------------------------------------ESTUDIANTE BUSCADO-----------------------------------------------");
		mostrar();
		}
	}
	public void buscar_editar(String dato,String line, int aux) throws IOException{ 
		int op;
		int pos=0; 
		String mod;
		if (dato.equals(this.matricula)||dato.equals(this.nombres)){
		System.out.println("-------------------------------------------------ESTUDIANTE BUSCADO-----------------------------------------------");		
		mostrar();
		do{
		 op = Integer.parseInt(JOptionPane.showInputDialog("OP1: Editar nombre"+"\n"+"OP2: Editar matricula"+"\n"+"OP3: Editar materia"+"\n"+"OP4: Editar nota parcial"+"\n"+"OP5: Editar nota examen final"+"\n"+"OP6: Salir"));
		switch(op){
		case 1:
			mod=JOptionPane.showInputDialog("Ingrese el nuevo nombre y apellido" );
		    this.nombres=mod;
		    System.out.println("-----------------------------------------------Modificado--------------------------------------------");
		    mostrar(); 
		break;
		case 2:
		    mod=JOptionPane.showInputDialog("Ingrese la nueva matricula" );  	
			this.matricula=mod;
		    System.out.println("-----------------------------------------------Modificado--------------------------------------------");
		    mostrar(); 
		break;
		case 3:
		    mod=JOptionPane.showInputDialog("Ingrese la nueva materia" );  	
			this.materia=mod;
		    System.out.println("-----------------------------------------------Modificado--------------------------------------------");
		    mostrar(); 
		break;
		case 4:
		    mod=JOptionPane.showInputDialog("Ingrese la nueva nota parcial" );  	
			this.nota_parcial=Float.parseFloat(mod);
		    System.out.println("-----------------------------------------------Modificado--------------------------------------------");
		    mostrar(); 
		break;
		case 5:
		    mod=JOptionPane.showInputDialog("Ingrese la nueva nota del examen" );  	
			this.exa=Float.parseFloat(mod);
		    System.out.println("-----------------------------------------------Modificado--------------------------------------------");
		    mostrar(); 
		break;
		case 6:
		    JOptionPane.showMessageDialog(null, "Saliendo.....!!");
		break;
		}
			
		}while(op!=6); 
		}
	}
	
	public void editar() throws IOException{
		String dato= JOptionPane.showInputDialog("Ingrese el dato: ");
		int aux=0;
		try{
			String ruta;
			ruta = main.class.getResource("estudiante.txt").toString();
			String ruta2=ruta.substring(6, ruta.length());
			BufferedReader read = new BufferedReader(new FileReader(ruta2));
			String line; 
			while ((line=read.readLine())!= null){  
				aux++; 
				lectura_estudiantes(line,aux);
				buscar_editar(dato,line,aux); 
			}
			}catch(FileNotFoundException e){
				JOptionPane.showMessageDialog(null, "NO EXISTE","ATENCION",JOptionPane.WARNING_MESSAGE);
			}
	}
    
	//Hace el proceso del buscar linea a linea 
	public void buscar_estudiantes() throws IOException{
		String matricula1= JOptionPane.showInputDialog("Ingrese el numero de matricula: ");
		int aux=0;
		try{
			String ruta;
			ruta = main.class.getResource("estudiante.txt").toString();
			String ruta2=ruta.substring(6, ruta.length());
			BufferedReader read = new BufferedReader(new FileReader(ruta2));
			String line; 
			while ((line=read.readLine())!= null){  
				aux++; 
				lectura_estudiantes(line, aux);
				buscar(matricula1); 
			}
			}catch(FileNotFoundException e){
				JOptionPane.showMessageDialog(null, "NO EXISTE","ATENCION",JOptionPane.WARNING_MESSAGE);
			}
	}
    
	public void aprobados(){
		if (this.nota_parcial>=22 &&this.exa>=8)
	    System.out.println("Nombre: "+this.nombres+" | Matricula: "+this.matricula+" | Materia: "+this.materia+" | Nota parcial: "+this.nota_parcial+" | Nota examen: "+this.exa); 
		if(this.nota_parcial>=10 && this.nota_parcial<=22){
			float aux2=0;
			aux2=30-this.nota_parcial;
			if(this.exa>=aux2)
				System.out.println("Nombre: "+this.nombres+" | Matricula: "+this.matricula+" | Materia: "+this.materia+" | Nota parcial: "+this.nota_parcial+" | Nota examen: "+this.exa); 	
			
		}
	}
	
	public void estudiantes_aprobados() throws IOException {
		int aux=0;
		try{
			String ruta;
			ruta = main.class.getResource("estudiante.txt").toString();
			String ruta2=ruta.substring(6, ruta.length());
			BufferedReader read = new BufferedReader(new FileReader(ruta2));
			String line; 
			while ((line=read.readLine())!= null){  
				aux++; 
				lectura_estudiantes(line, aux);
				aprobados();
			}
			}catch(FileNotFoundException e){
				JOptionPane.showMessageDialog(null, "NO EXISTE","ATENCION",JOptionPane.WARNING_MESSAGE);
			}
	}
    public String ingresar_estudiante(){
    	String nombre = JOptionPane.showInputDialog("Ingrese nombre y apellido");
    	String matricula = JOptionPane.showInputDialog("Ingrese el numero de matricula");
    	String materia = JOptionPane.showInputDialog("Ingrese la materia");
    	String n_p = JOptionPane.showInputDialog("Ingrese la nota parcial");
    	String examen = JOptionPane.showInputDialog("Ingrese la nota del examen");
    	
    	return nombre+" "+matricula+" "+materia+" "+n_p+" "+examen; 
    }
	public void guardar(String ingresado) throws IOException{
			String ruta;
			ruta = main.class.getResource("estudiante.txt").toString();
			String ruta2=ruta.substring(6, ruta.length());
			FileWriter edit = new FileWriter(ruta2,true); 
			edit.write("\n"+ingresado);
			edit.close();
	}

	public void modificar(String ingresado) throws IOException{
		String ruta;
		ruta = main.class.getResource("estudiante.txt").toString();
		String ruta2=ruta.substring(6, ruta.length());
		PrintWriter edit = new PrintWriter(ruta2); 
		edit.write("\n"+ingresado);
		edit.close();
}

}