package grafo;
import java.util.List;
public abstract class GrafoNoPonderadoMA<Type> {
	
	List<Type> vertices;
	 boolean[] matrizAdy;
	 
	 public GrafoNoPonderadoMA(){
		 
	 }

	 
	 public abstract boolean EsVacio();
	public abstract int NumeroDeVertices();
	public abstract int NumeroDeArcos();
	public abstract boolean EstaElVertice(Type V);
	public abstract boolean EstaElArco(int[] A);
	public abstract void InsertarVertice(String[] V);
	public abstract void InsertarArco(int[][] Arco);
	public abstract void Eliminar(Type V);
	public abstract void EliminarArco(Type Arco);
	public abstract List<Type> AdyacentesA(Type V);
	public abstract void Reemplazar(Type VViejo, Type VNuevo);
	public abstract List<Type> RecorrerALoAncho();
	public abstract List<Type> RecorrerEnProfundidad();
	public abstract boolean EsConexo();
	public abstract List<Type> MenorCamino(Type V1, Type V2);
	 
}
