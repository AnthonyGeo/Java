
public class main {

	public static void main(String[] args) {
		controlador  item1 = new controlador(); 
		controlador  item2 = new controlador(); 
		item1.color="Verde"; 
		item2.color="Rojo";
		
		item1.setCodigo("001");
		item2.setCodigo("002");
		
		item1.setTamano(2);
		item2.setTamano(3);
		
		item1.mostrar();
		item2.mostrar();

	}

}
