
import javax.swing.JOptionPane;

public class cadena {
	
	String cadena; 
    int aux; 	
	public cadena(String cadena){
		this.cadena=cadena; 
	}
	
	public boolean verificar(){
		
		aux=cadena.length(); 
		String aux1 = cadena.substring(0,2); 
		if(aux==1){
			 JOptionPane.showMessageDialog(null, "Cadena Invalida", "ERROR", JOptionPane.ERROR_MESSAGE);
		 }else if(aux1.equals("ca")){
			 return true; 
		 }else 
			 return false;
		return false; 
	}
	protected void finalize(){
		 JOptionPane.showMessageDialog(null, "CERRANDO PROGRAMA", "ATENCION", JOptionPane.WARNING_MESSAGE);
	}

}
