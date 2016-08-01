package multihiloFichero;
public class tiempo implements Runnable{

	 int count;
	 Thread thrd;
	 static boolean stop = false;
	 static String currentName;
	 
	
	 tiempo(String name) {
		 thrd = new Thread(this, name);
		 count = 0;
		 currentName = name;
		 } 
	public void run() {
		System.out.println(thrd.getName() + " Iniciando");
		 do {
		 count++;
		 if(currentName.compareTo(thrd.getName()) != 0) {
		 currentName = thrd.getName();
		 	}
		 }while(stop == false && count < 10000);
		 stop = true;
	}
}
		