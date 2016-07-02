package usoTry;
import javax.swing.JOptionPane; 

public class main {

	public static void main(String[] args) {
		
	try{ 
		
		int dato = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un numero: "));
		JOptionPane.showMessageDialog(null, "APLICACION TERMINADA CORRECTAMENTE","AVISO",JOptionPane.WARNING_MESSAGE);	
	 
	}catch(Exception e){
		JOptionPane.showMessageDialog(null, "INGRESO INVALIDO","ERROR",JOptionPane.ERROR_MESSAGE);
	 }
   }
}
