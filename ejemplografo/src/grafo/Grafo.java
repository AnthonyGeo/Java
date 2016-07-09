package grafo;

import java.awt.List;

public abstract class Grafo<Type> {
	
	public Grafo(){
		
	}
	
	public abstract boolean EsVacio();
	public abstract int NumeroDeVertices();
	public abstract boolean EstaElVertice(Type V);
	public abstract boolean EstaEnElArco(Type Arco);
	public abstract void InsertarVertice(Type V);
	public abstract void InsertarArco(Type Arco);
	public abstract void Eliminar(Type V);
	public abstract void EliminarArco(Type Arco);
	public abstract List AdyacenteA(Type V);
	public abstract void Reemplazar(Type VViejo, Type VNuevo);
	public abstract List RecorrerALoAncho();
	public abstract List RecorrerEnProfundidad();
	public abstract boolean EsConexo();
	public abstract List MenorCamino(Type V1, Type V2);
	

}
