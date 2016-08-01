package multihilo;
import java.io.BufferedReader;
import java.io.FileReader;
import  java.lang.Runnable;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

class Multihilo implements Runnable {
	  private Thread hilo;
	  private String nombreHilo;

	  Multihilo(String nombre){
	    nombreHilo = nombre;
	    System.out.println("Creando " + nombreHilo);
	  }

	  public void run() {
	    System.out.println("Ejecutando " + nombreHilo );
	    try {
	      for(int i = 0; i < 10; i++) {
	        System.out.println("Hilo: " + nombreHilo + ", " +"Contador"+" "+ i);
	        Thread.sleep(100);
	      }
	    } catch (InterruptedException e) {
	      System.out.println("Hilo " + nombreHilo + " Interrumpido");
	    }

	    System.out.println("Hilo " + nombreHilo + " Finalizado");
	  }

	  public void start () {
	    System.out.println("Iniciando " + nombreHilo );
	    if (hilo == null) {
	      hilo = new Thread (this, nombreHilo);
	      hilo.start();
	    }
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
				xstream.alias("Estudiante", Estudiante.class);
				List lst_estudiante = new ArrayList();
				lst_estudiante = (List) xstream.fromXML(contenido_xml);
				Estudiante a = new Estudiante();
				Estudiante b = new Estudiante();
				a = (Estudiante) lst_estudiante.get(0);
				b = (Estudiante) lst_estudiante.get(1);
				System.out.println(a.getMatricula());
				System.out.println(b.getNombres());
		}
	}

