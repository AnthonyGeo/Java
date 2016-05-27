import javax.swing.JOptionPane;

public class suma {

	 int arr[] = new int [10];
	 int resultado=0;
	 
		
		public suma(int []arr){
			for(int i=0;i<4;i++)
			this.arr[i]=arr[i]; 
		}

		
		public void sumar(){ 
		 for(int i=0 ;i<4;i++){
			 for(int x=0;x<4;x++){
				 if(i!=x && arr[i]==arr[x]){
					 arr[i]=0;
					 arr[x]=0;
				 }
			 }
		 }
		 for(int j=0;j<4;j++){
			 resultado=resultado+arr[j]; 
		 }
		 JOptionPane.showMessageDialog(null ,"La suma es: "+ Integer.toString(resultado));
	 }

}
