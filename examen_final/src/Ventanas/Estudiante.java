package Ventanas;

public class Estudiante {
	
	private String matricula;
	private String nombres;
	private String direccion;
	private String ciudad;
	private String edad;
	public Estudiante(){}
	
	public Estudiante(String matricula, String nombres, String direccion, String ciudad,String edad){
	this.matricula=matricula;
	this.nombres=nombres;
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
		return nombres;
	}

	public void setNombre(String nombres) {
		this.nombres = nombres;
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
