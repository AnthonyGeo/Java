package multihiloFichero;

import java.io.BufferedReader;  
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import  java.lang.Runnable;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;


public class hilos implements Runnable  {

	
	private String nombre = null;
	private String matricula=null; 
	private String direccion = null; 
	private String ciudad=null;
	private String esmeraldas="Esmeraldas";
	private int edad=0; 
	private Thread fichero; 
	private Thread xml; 
	BufferedReader in;
	private long t1;
	private long t2;
	
	public void run()  {
		t1= System.currentTimeMillis(); 
	try {
    	lecturaFicheroEsmeraldas();
    	System.out.println("----------------------------------*******ADULTOS*****-----------------------------------------");
    	lecturaFicheroAdultos();
	} catch (IOException e) {	
		e.printStackTrace();
	}finally{
		t2=System.currentTimeMillis();
	}
	String str=String.valueOf(t2-t1); 
	System.out.println("Tiempo de ejecucion: "+str);
   }
	
	public void lecturaFicheroEsmeraldas() throws IOException{
		try{
			in = new BufferedReader(new FileReader("file.txt"));
			String line; 
			while ((line=in.readLine())!= null){
				 sacarDatosEsmeraldas(line);
			}
			}catch(FileNotFoundException e){
				JOptionPane.showMessageDialog(null, "NO EXISTE","ATENCION",JOptionPane.WARNING_MESSAGE);
			}
	}
	
	public void lecturaFicheroAdultos() throws IOException{
		try{
			in = new BufferedReader(new FileReader("file.txt"));
			String line; 
			while ((line=in.readLine())!= null){
				 sacarDatosAldultos(line);
			}
			}catch(FileNotFoundException e){
				JOptionPane.showMessageDialog(null, "NO EXISTE","ATENCION",JOptionPane.WARNING_MESSAGE);
			}
	}
	

	
	public void sacarDatosEsmeraldas(String line){
		int pos=0;
		for(int i=0; i<line.length();i++){
			 if(line.substring(i,i+1).equals("|")){
				 pos++; 
				 if(pos==1){
			       this.matricula=line.substring(0,i);  		 
				 }
				 if(pos==2){
					 this.nombre=line.substring(this.matricula.length()+1,i); 
				 }
				 if(pos==3){
					 this.direccion=line.substring(this.matricula.length()+this.nombre.length()+2,i); 
				 }
				 if(pos==4){
					 this.ciudad=line.substring(this.matricula.length()+this.nombre.length()+this.direccion.length()+3,i); 
					 this.edad=Integer.parseInt(line.substring(this.matricula.length()+this.nombre.length()+this.direccion.length()+this.ciudad.length()+4));
				 }
			 }			  
		}
		esmeraldas();
		
	}
	
	public void sacarDatosAldultos(String line){
		int pos=0;
		for(int i=0; i<line.length();i++){
			 if(line.substring(i,i+1).equals("|")){
				 pos++; 
				 if(pos==1){
			       this.matricula=line.substring(0,i);  		 
				 }
				 if(pos==2){
					 this.nombre=line.substring(this.matricula.length()+1,i); 
				 }
				 if(pos==3){
					 this.direccion=line.substring(this.matricula.length()+this.nombre.length()+2,i); 
				 }
				 if(pos==4){
					 this.ciudad=line.substring(this.matricula.length()+this.nombre.length()+this.direccion.length()+3,i); 
					 this.edad=Integer.parseInt(line.substring(this.matricula.length()+this.nombre.length()+this.direccion.length()+this.ciudad.length()+4));
				 }
			 }			  
		}
		adultos();
		
	}
	
	public void esmeraldas(){
		if(this.esmeraldas.equals(this.ciudad))
			mostrar(); 
	}
	
	public void adultos(){
		if(this.edad>=40)
			mostrar(); 
	}
	
	
	public void mostrar(){
		System.out.println("Matricula: "+this.matricula+" Nombre: "+this.nombre+" Direccion: "+this.direccion+" Ciudad: "+this.ciudad+" Edad: "+this.edad);
	}
	
	 
	 public void start () {
		    System.out.println("Iniciando");
		    if (fichero == null) {
		      fichero = new Thread (this);
		      fichero.start();
		    }
		   
		  }	

}
