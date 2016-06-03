package practicas_array;
import javax.swing.JOptionPane; 
public class array {
	int arr[] = new int [8];
	 
		
		public array(int []arr){
			for(int i=0;i<8;i++)
			this.arr[i]=arr[i]; 
		}
		public void maximo(){ 
			int max=arr[0]; 
			 for(int i=0 ;i<8;i++){
				if (arr[i]>max)
					max=arr[i]; 
				 }
			 JOptionPane.showMessageDialog(null ,"Maximo: "+ Integer.toString(max));
			 }
		public void minimo(){ 
			int min=arr[0]; 
			 for(int i=0 ;i<8;i++){
				if (arr[i]<min)
					min=arr[i]; 
				 }
			 JOptionPane.showMessageDialog(null ,"Minimo: "+ Integer.toString(min));
			 }
		public void promedio(){ 
			float prom=0;
			int c=0; 
			 for(int i=0 ;i<8;i++){
					prom=prom+arr[i];
				c++; 
				 }
			 JOptionPane.showMessageDialog(null ,"Promedio: "+ Float.toString(prom/c));
			 }
		public void ordenar(){
			for(int i = 0; i < arr.length - 1; i++)
	        {
	            for(int j = 0; j < arr.length - 1; j++)
	            {
	                if (arr[j] > arr[j + 1])
	                {
	                    int tmp = arr[j+1];
	                    arr[j+1] = arr[j];
	                    arr[j] = tmp;
	                }
	            }
	        }
	        for(int i = 0;i < arr.length; i++)
	        {
	            System.out.print(arr[i]+"\n");
	        }
		}
}
