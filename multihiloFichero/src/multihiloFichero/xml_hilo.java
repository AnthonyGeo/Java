package multihiloFichero;

import java.io.BufferedReader; 
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
 
public class xml_hilo implements Runnable {
	
	int count;
	 Thread thrd;
	 static boolean stop = false;
	 static String currentName;
	private Thread xml; 
	private long t1;
	private long t2;
	
	xml_hilo(String name) {
		 thrd = new Thread(this, name);
		 count = 0;
		 currentName = name;
		 }
	
	public void leer_xml(String nombre_xml) throws Exception{
		
		 String contenido_xml = "";
			BufferedReader br = new BufferedReader(new FileReader(nombre_xml));
			try {
			    StringBuilder sb = new StringBuilder();
			    String line = br.readLine();

			    while (line != null) {
			        sb.append(line);
			        sb.append(System.lineSeparator());
			        line = br.readLine();
			    }
			
			    contenido_xml = sb.toString();
			}
			catch(Exception e){
				 System.out.println("Error al leer el fichero");
			 }finally {
			    br.close();
			}
			
			XStream xstream = new XStream(new DomDriver());
			xstream.alias("Alumno" , Alumno.class);
			List lst_estudiante = new ArrayList();
			lst_estudiante = (List) xstream.fromXML(contenido_xml);
			Alumno a = new Alumno();
			for(int i=0;i<10;i++){
				a = (Alumno) lst_estudiante.get(i);
				System.out.println("Matricula: "+a.getMatricula()+" Nombre: "+a.getNombres()+" Direccion: "+a.getDireccion()+" Ciudad: "+a.getCiudad()+" Edad: "+a.getEdad());
					
			}
			System.out.println("-----------------------------------------Esmeraldas-------------------------------------------");

			for(int i=0;i<10;i++){
			a = (Alumno) lst_estudiante.get(i);
			if(a.getCiudad().equals("Esmeraldas"))
			System.out.println("Matricula: "+a.getMatricula()+" Nombre: "+a.getNombres()+" Direccion: "+a.getDireccion()+" Ciudad: "+a.getCiudad()+" Edad: "+a.getEdad());
		}
			System.out.println("-----------------------------------------ADULTOS------------------------------------------------");

			for(int i=0;i<10;i++){
				a = (Alumno) lst_estudiante.get(i);
				if(a.getEdad()>=18)
				System.out.println("Matricula: "+a.getMatricula()+" Nombre: "+a.getNombres()+" Direccion: "+a.getDireccion()+" Ciudad: "+a.getCiudad()+" Edad: "+a.getEdad());
			}
}

	
	public void run() {
		System.out.println(thrd.getName() + " Iniciando");
		 do {
		 count++;
		 if(currentName.compareTo(thrd.getName()) != 0) {
		 currentName = thrd.getName();
		 	}
		 }while(stop == false && count < 10000);
		 stop = true;
		t1= System.currentTimeMillis(); 
		try {
	    	leer_xml("file.xml"); 
		} catch (IOException e) {	
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			t2=System.currentTimeMillis();
		}
		String str=String.valueOf(t2-t1); 
		System.out.println("Tiempo de ejecucion: "+str);   
	}
	 public void start () {
		    System.out.println("Iniciando");
		    if (xml == null) {
		      xml = new Thread (this);
		      xml.start();
		    }
		   
		  }	

}
