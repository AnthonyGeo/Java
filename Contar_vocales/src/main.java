import javax.swing.JOptionPane;

public class main {

	public static void main(String[] args) {
		contador cont = new contador(); 
		cont.setCadena(JOptionPane.showInputDialog("Ingrese la cadena: "));
        cont.contar();		
	}
}
