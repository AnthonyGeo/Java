package direciones;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;


public class ip implements inter_ip {
	
	private String line,aux,ruta,ip,fecha,list[]=new String [2000];
	private String q;
	private String arr[]=new String[2000]; 
	private int pos,cont=0;
	private String fecha1="";
	private String ip1="";
	
	public void lectura() throws IOException{
	try{
		int h=0,i=1,k=0,d=0;
		ruta = ip.class.getResource("log.log").toString();
		ruta=ruta.substring(6, ruta.length());
				ruta=ruta.replace("%20"," "); 
		BufferedReader read = new BufferedReader(new FileReader(ruta));
		while ((line=read.readLine())!= null){
		for(int x=0;x<line.length();x++){
		  if(line.substring(i-1,i).equals("[")){
			  pos++;
			  if(pos==1)
			  ip=line.substring(0,i-5);
		  }
		  if(line.substring(i-1,i).equals("]") ){
			  if(pos==1)
			  fecha=line.substring(ip.length()+5,i-16); 
		  }
		  i++;
		  list[k]=ip+" "+fecha;
		} 
		k++;
		
	    
		i=1;
		pos=0;
		cont=0; 
		}
		int acu=0;
		for(int f=0;f<k;f++){ 
			d=0;
			aux=list[f];
			if(aux!=" "){
			for(int t=0;t<k;t++){ 
	    	if(aux.equals(list[t])){
	    		d++;
	    		
	    		for(int o=0;o<aux.length();o++){
	    		if(aux.substring(o,o+1).equals(" ")){
	    		 ip1=aux.substring(0,o);
	    		fecha1=aux.substring(o);
	    		}
	    		}
	    		 list[t]=" ";
	    	} 
		}
			h++; 
		System.out.println(h+") "+"Ip:"+ip1+" Intentos: "+d+" Fecha: "+fecha1);
		}
	    }
		}catch(FileNotFoundException e){
			JOptionPane.showMessageDialog(null, "NO EXISTE","ATENCION",JOptionPane.WARNING_MESSAGE);
		}
	}
}

