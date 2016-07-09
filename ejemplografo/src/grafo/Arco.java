package grafo;

public abstract class Arco<Type> {
	Type vertice1;
	Type vertice2;
	
	public Arco(Type vertice1, Type vertice2){
		
	}
	
	public abstract Type getVertice1();
	public abstract Type getVertice2();
	
	
}
