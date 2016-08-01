package multihiloFichero;

public class Alumno implements alumno_interface {
	
	private String matricula;
	private String nombres;
	private String direccion;
	private String ciudad;
	private int edad;
	
	
	public Alumno(){}
	public Alumno(String matricula, String nombres, String direccion, String ciudad, int edad){
		this.matricula= matricula;
		this.nombres = nombres;
		this.direccion = direccion;
		this.ciudad = ciudad;
		this.edad=edad;
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
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	

}
