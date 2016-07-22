package calculadora;

import javax.swing.JOptionPane;

public class calculadora {

	float num1; 
	float num2; 
	 
	public calculadora( float num1 , float num2){
		this.num1=num1; 
		this.num2=num2; 
	}
	
   public float get_num1(){
	   return this.num1 = num1; 
	   
   }
   
    public float get_num2(){
    	return this.num2 = num2; 
    }
    
    public void  set_num1(int num1){
    	this.num1 = num1; 
    }
	
    public void  set_num2(int num2){
    	this.num2 = num2; 
    }
	
    public void suma (){
    	float resultado = this.num1+this.num2; 
    
    	JOptionPane.showMessageDialog(null ,"La suma es: "+ Float.toString(resultado)); 
    	
    }
    
    public void resta (){
    	float resultado = this.num1-this.num2; 
        
    	JOptionPane.showMessageDialog(null ,"La resta es: "+ Float.toString(resultado)); 
    	
    }
    
    public void multiplicacion (){
    	float resultado = this.num1*this.num2; 
        
    	JOptionPane.showMessageDialog(null ,"La multiplicacion es: "+ Float.toString(resultado)); 
    
    }
    
    public void division (){
    	float resultado = this.num1/this.num2; 
        
    	JOptionPane.showMessageDialog(null ,"La division es: "+ Float.toString(resultado)); 
    
    }
    public void raiz (float num){
    	float resultado =(float) Math.sqrt(num); 
    	JOptionPane.showMessageDialog(null ,"La raiz es: "+ Float.toString(resultado)); 
    
    }
    
    public void seno (float num){
    	float resultado = (float) Math.sin(num*2.0*Math.PI/360); 
    	JOptionPane.showMessageDialog(null ,"Seno es: "+ Float.toString(resultado)); 
    
    }
    public void coseno (float num){
    	float resultado = (float) Math.cos(num*2.0*Math.PI/360); 
    	JOptionPane.showMessageDialog(null ,"Coseno es: "+ Float.toString(resultado)); 
    
    }
    
    public void tangente (float num){
    	float resultado = (float) Math.tan(num*2.0*Math.PI/360); 
    	JOptionPane.showMessageDialog(null ,"Tangente es: "+ Float.toString(resultado)); 
    
    }
    
}
