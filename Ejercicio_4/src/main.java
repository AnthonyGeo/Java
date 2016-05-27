import javax.swing.JOptionPane; 
public class main {

	public static void main(String[] args) {
		int arr[]=new int[10]; 
		
		for(int i=0;i<4;i++){
			arr[i]= Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero:"+Integer.toString(i+1)));
			
		}
		suma sum = new suma(arr);
		sum.sumar();

	}

}
