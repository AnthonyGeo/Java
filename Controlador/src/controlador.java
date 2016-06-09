	
	public class controlador {
		
		 private String codigo; 
		 public String color; 
		 private int tamano;
		 
			public controlador(){
				
			}
		    
            public controlador(String codigo){
				this.codigo=codigo; 
			}
			
            public controlador(String codigo,String color){
				this.codigo=codigo; 
				this.color=color; 
		    }
            public controlador(String codigo,String color,int tamano){
            	this.codigo=codigo; 
				this.color=color; 
				this.tamano=tamano; 
			}
			
		    public String getCodigo() {
				return codigo;
			}
			public void setCodigo(String codigo) {
				this.codigo = codigo;
			}
			public int getTamano() {
				return tamano;
			}
			public void setTamano(int tamano) {
				this.tamano = tamano;
			}
			 
			public void mostrar(){
				System.out.println("codigo->"+this.codigo+" | color -> "+this.color+" | Tamaño ->"+int_to_string(this.tamano)); 
			}
			
			private String int_to_string(int size){
				switch (size){
				case 1:  
				    return "Pequeño";  
				case 2:  
				    return "Mediano"; 
				case 3:  
				    return "Grande"; 
			    default: 
			    	return "Tamaño desconocido"; 	    
				}
	}
}
