package practicas_matriz;

import javax.swing.JOptionPane;

public class matriz {
	int filas; 
	int columnas; 
	int arr[][]=new int [filas][columnas];
	 
	
	public matriz(int filas, int columnas,int [][]arr ){
		this.filas=filas;
		this.columnas=columnas;
		this.arr=arr; 
	}
	public void maximo(){ 
		int max=arr[0][0];
		int f = 0;
		int c=0; 
		 for(int i=0 ;i<filas;i++){
			 for(int x=0;x<columnas;x++){ 
			 if (arr[i][x]>max){
				max=arr[i][x];
				f=i;
				c=x;
			                }        
			          }
			 }
		 JOptionPane.showMessageDialog(null ,"El maximo esta en la fila: "+ Integer.toString(f+1)+" Columna: "+ Integer.toString(c+1));
		 JOptionPane.showMessageDialog(null ,"Maximo: "+ Integer.toString(max));
		 }
	public void minimo(){ 
		int min=arr[0][0];
		int f = 0;
		int c=0; 
		 for(int i=0 ;i<filas;i++){
			 for(int x=0;x<columnas;x++){ 
			 if (arr[i][x]<min){
				min=arr[i][x];
				f=i;
				c=x;
			                }        
			          }
			 }
		 JOptionPane.showMessageDialog(null ,"El minimo esta en la fila: "+ Integer.toString(f+1)+" Columna: "+ Integer.toString(c+1));
		 JOptionPane.showMessageDialog(null ,"Minimo: "+ Integer.toString(min));
		 }
	public void promedio(){ 
		float suma=0;
		
		 for(int i=0 ;i<filas;i++){
			 for(int x=0;x<columnas;x++){ 
				suma=suma+arr[i][x];     
			          }
			 }
		 JOptionPane.showMessageDialog(null ,"Promedio: "+ Float.toString(suma/(filas*columnas)));
		 }
	
	public void ordenar(){
		for( int i=0; i <filas; i++){
        	for( int j=0;j< columnas; j++){
        		for(int x=0; x < filas; x++){
       				for(int y=0; y <columnas; y++){
						if(arr[i][j] < arr[x][y]){
						int t = arr[i][j];
						arr[i][j] = arr[x][y];
						arr[x][y] = t;
						}
					}
			}
} 	}	



		System.out.print( "—————————–"+"\n");
			for(int i=0; i<filas; i++){
				for(int j=0; j<columnas; j++){
				System.out.print(arr [i][j]+"  ");
			}
			System.out.print( " "+"\n");
		}
		
	}

}
