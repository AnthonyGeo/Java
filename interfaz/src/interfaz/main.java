package interfaz;
import javax.swing.JOptionPane; 
public class main {

	public static void main(String[] args) {
		estudiante estu= new estudiante(); 
		estu.setAnioAtual(Integer.parseInt(JOptionPane.showInputDialog("Ingrese el año actual: ")));
		estu.setAnioNacimiento(Integer.parseInt(JOptionPane.showInputDialog("Ingrese el año de nacimiento: ")));
        estu.setNombre(JOptionPane.showInputDialog("Ingrese le nombre: "));
		System.out.println(estu.getNombre()+" Tiene la edad de: "); 
        System.out.println(estu.edad(estu.getanioactual(),estu.getanio()));
	}

}
