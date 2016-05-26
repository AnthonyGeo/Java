import javax.swing.JOptionPane;
public class main {

	public static void main(String[] args) {
		
		String cadena;
		
		cadena=(JOptionPane.showInputDialog("Ingrese la cadena:"));
		
		cadena cad = new cadena(cadena);
		
		cad.verificar(); 
		if(cad.verificar()==true){
			 JOptionPane.showMessageDialog(null, "Cadena Valida", "Correcto", JOptionPane.INFORMATION_MESSAGE);
			
		}else 
			JOptionPane.showMessageDialog(null, "Cadena No Valida", "ERROR", JOptionPane.ERROR_MESSAGE);
		
       cad = null;
       System.gc();
		
	}

}
