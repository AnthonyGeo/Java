import javax.swing.JOptionPane;

public class main {

	public static void main(String[] args) {
		figura rectangulo =  new figura();
		rectangulo.set_altura(Integer.parseInt(JOptionPane.showInputDialog("Ingrese altura:")));
		rectangulo.set_ancho(Integer.parseInt(JOptionPane.showInputDialog("Ingrese ancho:")));
		System.out.println("Tu altura es: ");
		System.out.println(rectangulo.get_altura());		
		System.out.println("Tu ancho es: ");
		System.out.println(rectangulo.get_ancho());
		rectangulo.dibujar(rectangulo.get_altura(), rectangulo.get_ancho());		
	}

}
