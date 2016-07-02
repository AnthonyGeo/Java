package finalClass;

    class finalclase {
    private int base; 
     private int altura; 
	
   public finalclase(){
	 
   }
    
	  public int getBase() {
		return base;
	}



	public void setBase(int base) {
		this.base = base;
	}



	public int getAltura() {
		return altura;
	}



	public void setAltura(int altura) {
		this.altura = altura;
	}



	public int area1(int base, int altura){
		return base*altura; 
	}
	
	final  public void calcular(){
		  System.out.println("Su area es: "+area1(base , altura)); 
		}
	
}
