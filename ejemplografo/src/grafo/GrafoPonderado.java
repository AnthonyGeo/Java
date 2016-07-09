package grafo;

public abstract class GrafoPonderado<Type> extends Grafo<Type> {

	public abstract void ModificarPeso(Type V1, Type V2, int nuevopeso);
	
}
