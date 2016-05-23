package aplicacion;

import javax.swing.JOptionPane;

public class main {

	public static void main(String[] args) {
		int op1,op2; 
		 
		op1 = JOptionPane.showConfirmDialog(null, "¿Es dia laborable?", "Pregunta 1",JOptionPane.YES_NO_OPTION);
		op2 = JOptionPane.showConfirmDialog(null, "¿Estas de vaciones?", "Pregunta 2",JOptionPane.YES_NO_OPTION);
		opcion op = new opcion(op1 , op2);
		op.pregunta();

	}

}
