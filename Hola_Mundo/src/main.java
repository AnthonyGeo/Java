import javax.swing.JOptionPane;

public class main {

	public static void main(String[] args) {
		
	Robot walle =  new Robot();
	//walle.set_nombre("Anthony Hernandez");
	walle.set_nombre(JOptionPane.showInputDialog("Ingrese el nombre:"));
	walle.set_edad(Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad:")));
	System.out.println("Tu nombre es: ");
	System.out.println(walle.get_nombre());
	
	System.out.println("Tu edad es: ");
	System.out.println(walle.get_edad());
	
		
	}

}
