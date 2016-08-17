package multihiloFichero;

import java.io.IOException;
public class main {

	public static void main(String[] args) throws Exception {
		 hilos hilo = new hilos("Hilo 1"); 
		 xml_hilo hilo2 = new xml_hilo("Hilo 2"); 
		 System.out.println(); 
		 hilo.thrd.setPriority(Thread.MIN_PRIORITY);
		 hilo2.thrd.setPriority(Thread.MAX_PRIORITY);
		 hilo.thrd.start();
		 hilo2.thrd.start();
		 try {
		 hilo.thrd.join();
		 hilo2.thrd.join();
		 }
		 catch(InterruptedException exc) {
		 System.out.println("Main thread interrupted.");
		 }
		 System.out.println("\nPrioridad alta con: " +
		 hilo.count);
		 System.out.println("Prioridad baja con: " +
		 hilo2.count);
		 System.out.println(); 
}

}
