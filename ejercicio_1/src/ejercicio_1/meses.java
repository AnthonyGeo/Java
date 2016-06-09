	package ejercicio_1;
	import javax.swing.JOptionPane;
	public class meses {
		String mes[]= {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","noviembre","Diciembre"};
		int pos; 
		public meses(){ 
		}
		public void mostrar(){	
			pos=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el mes a mostrar:"));
			if(pos<12)
			JOptionPane.showMessageDialog(null, mes[pos-1]);
			else
				JOptionPane.showMessageDialog(null, "Error");
		}
		
	
	}
