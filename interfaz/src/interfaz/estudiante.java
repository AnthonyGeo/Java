package interfaz;

public class estudiante implements persona {

	int anio_nac; 
	int anio_actual; 
	String nombre; 
	
	
	
	public int edad(int anio_actual, int anio_nac) {
		// TODO Auto-generated method stub
		return anio_actual-anio_nac;
	}

	
	public void setAnioNacimiento(int a) {
		this.anio_nac=a; 
		
	}

	
	public int getanio() {
		return this.anio_nac;
	}
    public int getanioactual(){
    return this.anio_actual;	
    }
	
	public void setNombre(String nombre) {
		this.nombre=nombre; 
		
	}

	
	public String getNombre() {
		return this.nombre;
	}


	@Override
	public void setAnioAtual(int b) {
		this.anio_actual=b; 
		
	}

}
