package ejercicio_5;
import javax.swing.JOptionPane;


public class main {

	public static void main(String[] args) {
		String cadena1; 
		cadena1= (JOptionPane.showInputDialog("Ingrese la cadena:"));

		cadena cad = new cadena(cadena1);
		cad.mayuscula();
		cad = null;
	    System.gc();
	}
	
}
