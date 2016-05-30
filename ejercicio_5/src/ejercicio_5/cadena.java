package ejercicio_5;
import javax.swing.JOptionPane;


public class cadena {
 private String cadena1;
String cadena2,cadena3; 

 public cadena(String cadena1){
	 this.cadena1=cadena1;  
 }
 
 public void mayuscula(){
	 int aux;
	 aux= cadena1.length(); 
	 if(aux < 3){
		 JOptionPane.showMessageDialog(null,cadena1.toUpperCase() );
	 }else{
		 cadena2 = cadena1.substring(0,cadena1.length()-3); 
		 cadena3 = cadena1.substring(cadena1.length()-3); 
		 JOptionPane.showMessageDialog(null, cadena2+cadena3.toUpperCase());
	 }
 }
 protected void finalize(){
	 JOptionPane.showMessageDialog(null, "CERRANDO PROGRAMA", "ATENCION", JOptionPane.WARNING_MESSAGE);
}

}
