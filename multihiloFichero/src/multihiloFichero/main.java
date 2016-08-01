package multihiloFichero;

import java.io.IOException;




public class main {

	public static void main(String[] args) throws Exception {
		 long tiempo1; 
		 tiempo mt1 = new tiempo("Hilo 1");
		 tiempo mt2 = new tiempo("Hilo 2");
		 mt1.thrd.setPriority(Thread.NORM_PRIORITY);
		 mt2.thrd.setPriority(Thread.MAX_PRIORITY);
		 mt1.thrd.start();
		 mt2.thrd.start();
		 try {
		 mt1.thrd.join();
		 mt2.thrd.join();
		 }
		 catch(InterruptedException exc) {
		 System.out.println("Main thread interrupted.");
		 }
		 System.out.println("\nPrioridad alta con: " +
		 mt1.count);
		 System.out.println("Prioridad baja con: " +
		 mt2.count);
		 System.out.println(); 
		hilos hilo = new hilos(); 
		hilo.start();
		xml_hilo hilo2 = new xml_hilo(); 
		System.out.println(); 
		hilo2.start();
		
		
		

	}

}
