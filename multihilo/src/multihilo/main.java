package multihilo;

public class main {

	public static void main(String[] args) {
		 
		  
		
	
		 Priority mt1 = new Priority("Hilo 1");
		 Priority mt2 = new Priority("Hilo 2");
		 // set the priorities
		 mt1.thrd.setPriority(Thread.NORM_PRIORITY);
		 mt2.thrd.setPriority(Thread.NORM_PRIORITY);
		 // start the threads
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
		 System.out.println("---------------------------------------------------------");
		 Multihilo hilo1 = new Multihilo( "Numero 1");
		 hilo1.start();
		 Multihilo hilo2 = new Multihilo( "Numero 2");
		 hilo2.start();
		 Multihilo hilo3 = new Multihilo( "Numero 3");
		 hilo3.start();
	}
	
	}


