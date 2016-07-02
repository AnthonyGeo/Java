package lecturafichero;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileNotFoundException; 
import javax.swing.JOptionPane; 
public class main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		try{
		String ruta;
		ruta = main.class.getResource("log.log").toString();
		//System.out.println(ruta);
		String ruta2=ruta.substring(6, ruta.length());
		//System.out.println(ruta2);
		BufferedReader read = new BufferedReader(new FileReader(ruta2));
		String line; 
		while ((line=read.readLine())!= null){
			System.out.println(line);  
		}
		}catch(FileNotFoundException e){
			JOptionPane.showMessageDialog(null, "NO EXISTE","ATENCION",JOptionPane.WARNING_MESSAGE);
		}
	}
}
