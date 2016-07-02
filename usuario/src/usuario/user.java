package usuario;
import java.util.Random; 
public class user implements interfaz{
	Random aux = new Random(); 
    private String correo; 
    private String a[]={"a","b","c","d","e","f","g","h","i","j","k","l","m","n","ñ","o","p","q","r","s","t","u","v","w","x","y","z"};
    private String b[]={"A","B","C","D","E","F","G","H","I","J","K","L","M","N","Ñ","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
    private String c[]={"0","1","2","3","4","5","6","7","8","9"}; 
    private String contra="";
    
     public user(){
    	 
     }
     public user(String correo){
    	 this.correo=correo;
     }
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	public void setContraseña(String contra) {
		this.contra = contra;
	}
	public String gen_Contraseña() {	
		int aux1=0;
		String v[]=new String[9];
 
		for(int i = 0 ; i<9 ;i++){
			aux1= aux.nextInt(3)+1;
		if(aux1==1){
			this.contra+=a[aux.nextInt(a.length)+0];
		}
		if(aux1==2){
			this.contra+=b[aux.nextInt(b.length)+0];
		}
		if(aux1==3){
			this.contra+=c[aux.nextInt(c.length)+0];
		} 
		}
		return this.contra; 
	}
	
	@Override
	public boolean es_fuerte(String password) {
		int a1=0,b1=0,c1=0,d=0,e=1;
		
		for(int i =0 ;i<password.length();i++){
			for(int x=0 ;x<a.length;x++){
				if(password.substring(e-1,e).equals(a[x])){
					a1++; 
				}
			}
				for(int j=0 ;j<b.length;j++){
					if(password.substring(e-1,e).equals(b[j])){
						b1++; 
					}
				}
					for(int k=0 ;k<c.length;k++){
						if(password.substring(e-1,e).equals(c[k])){
							c1++; 
			    }					
			}  
		e++;
		}
	if(a1 >= 1 && b1 ==2 && c1>=5){
		return true; 
	}else{
	return false;} 
	}
	@Override
	public boolean verifica_correo(String correo) {
		int a=1,aux=0;
		for(int i =0 ;i<correo.length();i++){
			if(correo.substring(a-1,a).equals("@"))
		    aux++;
			if(correo.substring(a-1,a).equals("."))
			    aux++;
				
		a++; 
		} 
		if(aux==2){
			return true;
		}
		else 
			return false; 
	}
    
	
    


}
