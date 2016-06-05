package practicas_matriz;

public class main {

	public static void main(String[] args) {
   
	int arr[][]={{19,1,7,8,9,10,6,3},{4,18,3,13,11,4,2,20}}; 

		
		matriz vector = new matriz(2,8,arr); 
		vector.maximo();
		vector.minimo();
        vector.promedio();
        vector.ordenar();
	}

}
