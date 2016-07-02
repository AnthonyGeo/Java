package herencia;

public class hija extends herencia {
	String style; 
	
	public hija(){
		
	}
	public hija(String style,double width,double heigth){
		super(width,heigth); 
		this.style=style; 
	}
	double area (){
		return (width*heigth)/2; 
	}
    
	public void motrar_stilo(){
		System.out.println("El estilo es-> "+style); 
	}
}
