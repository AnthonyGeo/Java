package herencia2;

public class estudiante extends persona{
	 private String codigo; 
	 private String carrera; 
	
	public estudiante(String cedula , String codigo){
		setCedula(cedula);
		this.codigo=codigo; 
	}
	
	public estudiante(String cedula , String nombre,String apellidos,String codigo){
		setCedula(cedula);
		setNombres(nombre);
		setApellidos(apellidos); 
		this.codigo=codigo; 
		
	}
	public estudiante(String nombres, String apellidos,String carrera){
		setNombres(nombres);
		setApellidos(apellidos); 
		this.carrera=carrera; 
	}
	public estudiante (String nombres ,String apellidos , String cedula,  String ciudad, String carrera, String codigo){
		setNombres(nombres);
		setApellidos(apellidos);
		setCedula(cedula);
		setCiudad(ciudad);  
		this.carrera=carrera;
		this.codigo=codigo; 
		 
	}
	
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	public void mostrar(){
		System.out.println("Nombres-> "+getNombres()+" Apellidos-> "+getApellidos()+" Cedula-> "+getCedula()+" Ciudad-> "+getCiudad()+" Carrera-> "+carrera+" Matricula->"+codigo); 
	}
	public void verificar(){
		if(getCiudad()=="Esmeraldas")
			mostrar(); 
	}

}
