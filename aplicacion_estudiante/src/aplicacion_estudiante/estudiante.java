package aplicacion_estudiante;
import java.util.Scanner;

import javax.swing.JOptionPane;
public class estudiante {
	private  String matricula; 
	private String nombres; 
	private String materia; 
	private float nota; 
	private float exa;
	Scanner sc=new Scanner(System.in);
	public estudiante(String nombres,String matricula,String materia,float nota,float exa){
		this.nombres=nombres;
		this.matricula=matricula;
		this.materia=materia;
		this.nota=nota;
		this.exa=exa; 
	}
	
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getMateria() {
		return materia;
	}
	public void setMateria(String materia) {
		this.materia = materia;
	}
	public float getNota() {
		return nota;
		
	}
	public void setNota(float nota) {
		this.nota = nota;
	}
	public float getExa() {
		return exa;
	}
	public void setExa(float exa) {
		this.exa = exa;
	} 
	
	public void mostrar(){
		System.out.println("Nombre: "+this.nombres+" | Matricula: "+this.matricula+" | Materia: "+this.materia+" | Nota parcial: "+this.nota+" | Nota examen: "+this.exa); 
		
	}
	
	public void aprobados(){
		if (this.nota+this.exa>=30)
	    System.out.println("Nombre: "+this.nombres+" | Matricula: "+this.matricula+" | Materia: "+this.materia+" | Nota parcial: "+this.nota+" | Nota examen: "+this.exa); 
		
			
	}
	public void buscar(String mat){ 
		if ( mat.equals(this.matricula))
		mostrar(); 
	  }
		
	
}
