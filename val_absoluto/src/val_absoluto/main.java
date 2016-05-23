package val_absoluto;
import javax.swing.JOptionPane;
public class main {

	public static void main(String[] args) {
	
		valor val = new valor();
		
		val.set_num(Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero:")));
		 if (val.get_num()<21){
			 JOptionPane.showMessageDialog(null ,"Resultado: "+ Integer.toString(Math.abs(val.get_num()-21)));
			 
		 }
		 else {
			 JOptionPane.showMessageDialog(null ,"Resultado: "+ Integer.toString((val.get_num()-21)*2));
		 }
		
	}

}
