package herencia;

public class main {

	public static void main(String[] args) {
		hija t1 =  new hija(); 
		hija t2 =  new hija();
		hija t3 =  new hija("Test",25,5);
	    
		t1.width=4.0;
		t1.heigth=1.8;
		t1.style="Lleno";
		
		t2.width=3.8;
		t2.heigth=2.5;
		t2.style="Vacio"; 
		
		System.out.println("Informacion del triangulo 1: "); 
		t1.mostrar();
		System.out.println("El area es: "+t1.area()); 
		t1.motrar_stilo();
	    
	    System.out.println("--------------------------------"); 		
	    System.out.println("Informacion del triangulo 2: "); 
		t2.mostrar();
		System.out.println("El area es: "+t2.area());
	    t2.motrar_stilo();
	    
	    t3.mostrar();
	    t3.motrar_stilo();
	     
	}

}
