package interfaz;

public interface persona {

	int edad(int anio_nac, int anio_actual);
    void setAnioNacimiento(int a);
    void setAnioAtual(int a);
    int getanio();
    int getanioactual();
    void setNombre(String nombre); 
    String getNombre(); 
	
}
