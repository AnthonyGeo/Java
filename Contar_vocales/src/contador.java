import javax.swing.JOptionPane;
public class contador {
	
	private String cadena; 
	private int  aux=0;
	
	public contador(){
		
	}

	public String getCadena() {
		return cadena;
	}

	public void setCadena(String cadena) {
		this.cadena = cadena;
	}
	
	public void contar(){
	  int aux2=cadena.length(); 
		for(int x=0 ;x<cadena.length();x++){
	  if(cadena.charAt(x)=='a'||cadena.charAt(x)=='e'||cadena.charAt(x)=='i'||cadena.charAt(x)=='o'||cadena.charAt(x)=='u')
			aux++; }
		JOptionPane.showMessageDialog(null, "La cadena tiene : "+Integer.toString(aux)+" vocales" );
	}

}
