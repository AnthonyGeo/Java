package grafo;

import java.util.List;




import java.util.*;



public class GrafoA<Type> extends GrafoNoPonderadoMA<Object>{

	boolean[] visitiadoProfunidad= new boolean [5];
	private List<String> vertices = new ArrayList<String>();
	private int [][] matriz_adyacente = new int[99][99];
	
	@Override
	public boolean EsVacio() {
		if(this.NumeroDeVertices()==0){
			return true;
		}
		return false;
	}

	@Override
	public int NumeroDeVertices() {
		// TODO Auto-generated method stub
		return vertices.size();
	}

	@Override
	public int NumeroDeArcos() {
		// TODO Auto-generated method stub
		int cont=0;
		for(int x=0; x<this.NumeroDeVertices();x++)
		{
			for(int y=0; y<this.NumeroDeVertices();y++)
			{
				if(this.matriz_adyacente[x][y]!=0)
				{
					if(this.matriz_adyacente[x][y]==this.matriz_adyacente[y][x]){
						cont++;
					}
				}
			}
		}
		return cont/2;
	}

	@Override
	public boolean EstaElVertice(Object V) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean EstaElArco(int[] A) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void InsertarVertice(String[] V) {
		// TODO Auto-generated method stub
		for(int i=0;i<V.length;i++){
			this.vertices.add(V[i]);
		}
		
		
	}

	@Override
	public void InsertarArco(int[][] Arco) {
		// TODO Auto-generated method stub
		if(Arco[0].length==this.NumeroDeVertices()&&Arco[1].length==this.NumeroDeVertices())
		{
			for(int x=0; x<Arco[0].length;x++)
			{
				for(int y=0; y<Arco[0].length;y++)
				{
					this.matriz_adyacente[x][y]=Arco[x][y];
					
				}
				
			}
		}else
		{
			System.out.println("Error el tamaño de la matriz de arco no coincide con el numero de vertices");
		}
		
		
	}

	@Override
	public void Eliminar(Object V) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void EliminarArco(Object Arco) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Object> AdyacentesA(Object V) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Reemplazar(Object VViejo, Object VNuevo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Object> RecorrerALoAncho() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> RecorrerEnProfundidad() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean EsConexo() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Object> MenorCamino(Object V1, Object V2) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean Completo()
	{
		int n=this.NumeroDeVertices();
		if(n>0 && this.NumeroDeArcos()==((n*(n-1))/2))
		{
			return true;
		}
		return false;
	}
	
	public int GradoDe(String Vertice){
		
		int cont=0;
		if(this.NumeroDeVertices()<=0 && this.NumeroDeArcos()<=0)
			return 0;
		
		int fila=vertices.indexOf(Vertice);
		
		
			for(int c=0; c<this.NumeroDeVertices();c++)
			{
				if(this.matriz_adyacente[fila][c]!=0)
				{
						cont++;
				}
			}
		
		return cont;
	}
	
	public void AislarVertice( String Vertice){
		 
		int pos = vertices.indexOf(Vertice); 
		if(pos >=0){
			for(int i=0; i<vertices.size();i++){
				this.matriz_adyacente[i][pos]=0;
				this.matriz_adyacente[pos][i]=0;
			}
		}
    }
	
	 /*public ArrayList<String> recorridoProfunidad(String nodoI) {
   
		 int pos= vertices.indexOf(nodoI); 
		 //Lista donde guardo los nodos recorridos

		        ArrayList<String> recorridos = new ArrayList<String>();

		        visitiadoProfunidad[0] = true;//El nodo inicial ya está visitado

		//Cola de visitas de los nodos adyacentes

		        ArrayList<Integer> cola = new ArrayList<Integer>();

		        recorridos.add(pos,nodoI);//Listo el nodo como ya recorrido

		        cola.add(pos);//Se agrega el nodo a la cola de visitas

		        while (!cola.isEmpty()) {//Hasta que visite todos los nodos

		            int j = cola.remove(0);//Se saca el primer nodo de la cola

		    //Se busca en la matriz que representa el grafo los nodos adyacentes

		            for (int i = 0; i < this.matriz_adyacente.length; i++) {

		//Si es un nodo adyacente y no está visitado entonces

		                if (this.matriz_adyacente[j][i] == 1 && !visitiadoProfunidad[i]) {

		                    cola.add(i);//Se agrega a la cola de visita

		//Se recorren los hijos del nodo actual de visita y se agrega el recorrido al la lista

		                    recorridos.addAll(recorridoProfunidad(nodoI));

		                    visitiadoProfunidad[i] = true;//Se marca como visitado

		                }

		            }

		        }

		        return recorridos;//Se devuelve el recorrido del grafo en profundidad

		    }*/
	 
	 public void mayoramenor(){
		 int aux; 
		 for(int i=0;i<5;i++){
			 for(int j=0;j<5;j++){
				 for(int x=0;x<5;x++){
					 for(int y=0;y<5;y++){
						 if(this.matriz_adyacente[i][j]>this.matriz_adyacente[x][y]){
							 aux=this.matriz_adyacente[i][j];
							 this.matriz_adyacente[i][j]=this.matriz_adyacente[x][y];
							 this.matriz_adyacente[x][y]=aux; 
						 }
					 }
				 }	 	 
			 }
		 }
	 
		 for(int i=0;i<this.matriz_adyacente.length;i++){
			 for(int j=0;j<this.matriz_adyacente.length;j++){
				 if(this.matriz_adyacente[i][j]!=0)
				System.out.print(this.matriz_adyacente[i][j]+" "); 
			 }
			 System.out.println(); 
		 }
	 }
	 
	 public void peso_mayor (){
		 int aux=this.matriz_adyacente[0][0];
		 for(int i=0;i<this.matriz_adyacente.length;i++){
			 for(int j=0;j<this.matriz_adyacente.length;j++){
				 if(this.matriz_adyacente[i][j]>aux){
					 aux=this.matriz_adyacente[i][j];
				 }
			 }
		 }
		 System.out.println(aux); 
	 }
	 
	 
}
	
