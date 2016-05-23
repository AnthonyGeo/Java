package aplicacion;

import javax.swing.JOptionPane;

public class opcion {
	
	int op1, op2; 
	
	public opcion ( int op1 , int op2){
		this.op1=op1;
		this.op2=op2; 
	}
	
	public void  pregunta(){
      
       if(op1 == JOptionPane.YES_NO_CANCEL_OPTION && op2 == JOptionPane.YES_NO_OPTION){
			JOptionPane.showMessageDialog(null, "Puedes descansar");
		}
		else {
			JOptionPane.showMessageDialog(null, "No puedes descansar");
		}
	}
	
	

}
