/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

/**
 *
 * @author Anthony Hernandez
 */
public class Objeto {
    private String matricula;
    private String nombre;
    private String direccion;
    private String ciudad;
    private String edad;
      
    
    
    public Objeto(String matricula, String nombre, String direccion,String ciudad,String edad) {
    	this.matricula=matricula;
    	this.nombre=nombre;
    	this.direccion=direccion;
    	this.ciudad=ciudad;
    	this.edad=edad;
        
    }



	public String getMatricula() {
		return matricula;
	}



	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getDireccion() {
		return direccion;
	}



	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}



	public String getCiudad() {
		return ciudad;
	}



	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}



	public String getEdad() {
		return edad;
	}



	public void setEdad(String edad) {
		this.edad = edad;
	}

   
    
}
