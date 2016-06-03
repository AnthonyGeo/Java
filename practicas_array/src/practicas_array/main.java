package practicas_array;

import javax.swing.JOptionPane;

public class main {

	public static void main(String[] args) {
		int arr[]={5,1,7,8,9,10,6,3}; 
		
		
		
		/*for(int i=0;i<8;i++){
			arr[i]= Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero "+Integer.toString(i+1)));
			
		}*/
		array vector = new array(arr); 
		vector.maximo();
		vector.minimo();
		vector.promedio();
		vector.ordenar();

	}

}
