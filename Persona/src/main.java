package tarea_Persona;


import java.util.Scanner;


    	public class main {
    	    public static void main(String[] args) {
    	        
    	    	persona persona_1 = new persona();
    	    	persona persona_2 = new persona();        
    	    	persona persona_3 = new persona();
    	    	persona persona_4 = new persona();
    	        Scanner sc = new Scanner(System.in);
    	        
    	        
    	        System.out.println(" Persona 1");
    	        System.out.print("Ingrese el nombre: ");
    	        persona_1.nombre = sc.next();
    	        System.out.print("Ingrese su apellido: ");
    	        persona_1.apellido = sc.next();
    	        System.out.print("Ingrese su cedula de indentidad: ");
    	        persona1.cedulaIdentidad = sc.next();
    	        System.out.print("Ingrese su edad: ");
    	        persona_1.fechaNacimiento = sc.nextInt();
    	        System.out.print("Ingrese telefono: ");
    	        persona1.telefono = sc.next();
    	        System.out.print("Ingrese su lugar de residencia: ");
    	        persona_1.lugarResidencia = sc.next();
    	        System.out.print("Ingrese 1=soltero 2=casado:: ");
    	        persona_1.casado = sc.nextInt();
    	       
    	        System.out.println("\nPersona 2");
    	        System.out.print("Ingrese el nombre: ");
    	        persona_2.nombre = sc.next();
    	        System.out.print("Ingrese apellido: ");
    	        persona_2.apellido = sc.next();
    	        System.out.print("Ingrese su cedula de indentidad: ");
    	        persona_2.cedulaIdentidad = sc.next();
    	        System.out.print("Ingrese edad: ");
    	        persona2.fechaNacimiento = sc.nextInt();
    	        System.out.print("Ingrese su telefono: ");
    	        persona_2.telefono = sc.next();
    	        System.out.print("Ingrese  el lugar de su residencia: ");
    	        persona_2.lugarResidencia = sc.next();
    	        System.out.print("Ingrese 1=soltero 2=casado:: ");
    	        persona_2.casado = sc.nextInt();
    	       
    	        System.out.println("\nPersona 3");
    	        System.out.print("Ingrese nombre: ");
    	        persona_3.nombre = sc.next();
    	        System.out.print("Ingrese apellido: ");
    	        persona_3.apellido = sc.next();
    	        System.out.print("Ingrese cedula de indentidad: ");
    	        persona_3.cedulaIdentidad = sc.next();
    	        System.out.print("Ingrese edad: ");
    	        persona_3.fechaNacimiento = sc.nextInt();
    	        System.out.print("Ingrese telefono: ");
    	        persona_3.telefono = sc.next();
    	        System.out.print("Ingrese lugar de residencia: ");
    	        persona_3.lugarResidencia = sc.next();
    	        System.out.print("Ingrese 1=soltero 2=casado: ");
    	        persona_3.casado = sc.nextInt();
    	   
    	        System.out.println("\nPersona 4");
    	        System.out.print("Ingrese el nombre: ");
    	        persona_4.nombre = sc.next();
    	        System.out.print("Ingrese apellido: ");
    	        persona_4.apellido = sc.next();
    	        System.out.print("Ingrese su cedula de indentidad: ");
    	        persona_4.cedulaIdentidad = sc.next();
    	        System.out.print("Ingrese su  edad: ");
    	        persona_4.fechaNacimiento = sc.nextInt();
    	        System.out.print("Ingrese telefono: ");
    	        persona_4.telefono = sc.next();
    	        System.out.print("Ingrese su lugar de residencia: ");
    	        persona_4.lugarResidencia = sc.next();
    	        System.out.print("Ingrese 1=soltero 2=casado: ");
    	        persona_4.casado = sc.nextInt();
    	     
    	        System.out.println("Personas que viven en Esmeraldas y son mayores a 30 años casados son: ");
    	        if(persona_1.lugarResidencia.equalsIgnoreCase("Esmeraldas") && persona_1.fechaNacimiento >= 30 && persona_1.casado == 1){
    	            System.out.println(persona1.nombre + " " + persona1.apellido);
    	        }
    	        if(persona_2.lugarResidencia.equalsIgnoreCase("Esmeraldas") && persona_2.fechaNacimiento >= 30 && persona_2.casado == 1){
    	            System.out.println(persona_2.nombre + " " + persona_2.apellido);
    	        }
    	        if(persona_3.lugarResidencia.equalsIgnoreCase("Esmeraldas") && persona_3.fechaNacimiento >= 30 && persona_3.casado == 1){
    	            System.out.println(persona_3.nombre + " " + persona_3.apellido);
    	        }
    	        if(persona_4.lugarResidencia.equalsIgnoreCase("Esmeraldas") && persona_4.fechaNacimiento >= 30 && persona_4.casado == 1){
    	            System.out.println(persona_4.nombre + " " + persona_4.apellido);
    	        }
    	    }
    	} 