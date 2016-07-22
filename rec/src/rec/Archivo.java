package rec;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Cristhian
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import static rec.Rec.list;

public class Archivo {
    
    void crear(ArrayList a,File txt) throws FileNotFoundException, IOException{
        try (FileWriter TextOut = new FileWriter(txt)) {
            
            Alumno aux;
            Iterator<Alumno> it= a.iterator();
            while(it.hasNext())
            {
                aux=it.next();
                TextOut.write(aux.getMateria()+","+aux.getMatricula()+","+aux.getNombre()+","+aux.getNota_total()+","+aux.getNota_exa()+"\r\n");
            }
            
        }
    }
    
    
    
    void xml() throws IOException{
		
		try
		{
			String texto = "";
			FileReader lector = new FileReader("C:\\Users\\Cristhian\\Desktop\\POO\\Programas\\Semanal2\\Estudiantes.txt");
			BufferedReader contenido = new BufferedReader(lector);
			
			File archivo = new File("C:\\Users\\Cristhian\\Desktop\\POO\\Programas\\Semanal2\\Estudiantes.xml");
			FileWriter escribir = new FileWriter(archivo,true);	
			
			while((texto = contenido.readLine()) != null){
				escribir.write(texto+"\r\n");
			}
			escribir.close();
		}
		catch(Exception e)
		{
			System.out.println("Error al escribir");
		}
} 
}
