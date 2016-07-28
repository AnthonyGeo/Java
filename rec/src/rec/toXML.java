package rec;

import java.io.BufferedReader; 
import java.io.FileReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;

import org.xml.sax.SAXException;

public class toXML {
	
	 BufferedReader in;
	 StreamResult out;
	 TransformerHandler th;
	
	public void creacion() {
        try {
        	String matricula = null,nombre=null,materia=null,notp=null,notaexa=null;
            in = new BufferedReader(new FileReader("estudiantes.txt"));
            out = new StreamResult("estudiantes.xml");
            openXml();
            String line;
            int pos=0;
            int pos2=0;
            while ((line = in.readLine()) != null) {
                pos=0;
            	pos2=0;
                for(int i=0;i<line.length();i++){
                	if(line.substring(i, i+1).equals(",")){
                		pos++;
                		if(pos==1){
                			 materia=line.substring(0,i);
                		}
                		if(pos==2){
                			 matricula=line.substring(materia.length()+1,i);
                		}
                		if(pos==3){
               			 nombre=line.substring(materia.length()+matricula.length()+2,i);
               		    }
                		if(pos==4){
               			 notp=line.substring(materia.length()+nombre.length()+matricula.length()+3,i);              	
                		}	
               	}
                	if(line.substring(i, i+1).equals(".")){
                		pos2++;
                		if(pos2==2)
                			notaexa=line.substring(i-2,i+2);
                	}
                
             }
            	procesar_txt(matricula,nombre,materia,notp,notaexa);
            }
            in.close();
            cerrarEtiqueta();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void openXml() throws ParserConfigurationException, TransformerConfigurationException, SAXException {

        SAXTransformerFactory tf = (SAXTransformerFactory) SAXTransformerFactory.newInstance();
        th = tf.newTransformerHandler();

        Transformer txt = th.getTransformer();
        txt.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
        txt.setOutputProperty(OutputKeys.INDENT, "yes");

        th.setResult(out);
        th.startDocument();
        th.startElement(null, null, "Estudiantes", null);
    }

    public void procesar_txt(String mat,String nom,String mate,String n_p,String n_e) throws SAXException {
    	th.startElement(null, null, "Estudiante", null);
    	th.startElement(null, null, "Matricula", null);
        th.characters(mat.toCharArray(), 0, mat.length());
        th.endElement(null, null, "Matricula");
        th.startElement(null, null, "Nombre", null);
        th.characters(nom.toCharArray(), 0, nom.length());
        th.endElement(null, null, "Nombre");
        th.startElement(null, null, "Materia", null);
        th.characters(mate.toCharArray(), 0, mate.length());
        th.endElement(null, null, "Materia");
        th.startElement(null, null, "NotaParcial", null);
        th.characters(n_p.toCharArray(), 0, n_p.length());
        th.endElement(null, null, "NotaParcial");
        th.startElement(null, null, "NotaExamen", null);
        th.characters(n_e.toCharArray(), 0, n_e.length());
        th.endElement(null, null, "NotaExamen");
        th.endElement(null, null, "Estudiante");
        
 
    }

    public void cerrarEtiqueta() throws SAXException {
        th.endElement(null, null, "Estudiantes");
        th.endDocument();


    }
    
}
