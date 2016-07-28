package multihilo;
import  java.lang.Runnable;

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
	}

