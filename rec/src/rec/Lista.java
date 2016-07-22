/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rec;

/**
 *
 * @author Cristhian
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;




public class Lista  {
    private  ArrayList<Alumno>  list;
    
     public Lista(){
        list=new ArrayList<>(); 
    }
     
     public void añadir(Alumno a){
        list.add(a);
    }
     
     public ArrayList lista(){
         return list;
     }
     
     public void setArrayList(ArrayList a){
         list = a;
     }
     
     public void limpiarArrayList(){
         list.clear();
     }
      public Alumno obtener(int pos){
    	 return list.get(pos);
     }
     
     public Alumno buscar(int codigo){	 
    	 for(int i=0; i< list.size(); i++)
    		 if(codigo == list.get(i).getMatricula())
    			 return list.get(i);
    	 return null;

     }
     public void mostrar_aprobados() {
        Alumno aux;
        Iterator<Alumno> it= list.iterator();
          for(int i=0;i<list.size();i++){
            aux=it.next();
              if (list.get(i).getNota_total()>= 22 && list.get(i).getNota_exa() >= 8) {
                //aux=it.next();     
                 System.out.println("Matricula: "+aux.getMatricula()+" Nombre: "+aux.getNombre()+" Materia: "+aux.getMateria()+" Nota Parcial: "+aux.getNota_total()+" Nota Examen: "+aux.getNota_exa());                
            }
              else if (list.get(i).getNota_total() >= 10 && list.get(i).getNota_exa() <= 20) {
                double aux2 = 0;
                aux2 = 30 - list.get(i).getNota_total();
                 if (list.get(i).getNota_exa() >= aux2) {
                //aux=it.next();     
                System.out.println("Matricula: "+aux.getMatricula()+" Nombre: "+aux.getNombre()+" Materia: "+aux.getMateria()+" Nota Parcial: "+aux.getNota_total()+" Nota Examen: "+aux.getNota_exa());                }
            }
        }
     }
     
      public void mostrar(){
        Alumno aux;
        Iterator<Alumno> it= list.iterator();
        while(it.hasNext())
        {
            aux=it.next();
            System.out.println("Matricula: "+aux.getMatricula()+" Nombre: "+aux.getNombre()+" Materia: "+aux.getMateria()+" Nota Parcial: "+aux.getNota_total()+" Nota Examen: "+aux.getNota_exa());
        }
    } 
     
  /*  public void Json(){
        for(int i=0; i< list.size(); i++){
        Alumno w = new Alumno();
        w.setNombre(list.get(i).getNombre());
        w.setMatricula(list.get(i).getMatricula());
        w.setMateria(list.get(i).getMateria());
        List<Alumno> c = new ArrayList<Alumno>();
        c.add(w);
    }
        JSONObject objAlumno = new JSONObject(w);
        try{
            for(Alumno z : c ){
                
            }
        } catch (Exception e) {
	        e.printStackTrace();
    }*/
}
