import javax.swing.JOptionPane;

public class ordenar {

	String[] a;
	
	public ordenar(String ...b){
		this.a=new String [b.length];  
		a=b; 
		
	}
	public void nombres(){
		int op; 
		do{
			op = Integer.parseInt(JOptionPane.showInputDialog("OP 1 : ASCENDENTE"+"\n"+"OP 2 : DESCENDENTE"+"\n"+"OP 3 : SALIR"));
		switch(op){
		case 1: 
			for(int i = 0; i<a.length; i++){ 
				for(int j = i; j<a.length; j++){ 
					if(a[i].compareTo(a[j])>0) 
				{ 
				String aux = a[i]; 
				a[i] = a[j]; 
				a[j] = aux; 
						} 
					} 
				} 
			  System.out.println("ASCENDENTE");
		         for(int i=0;i<a.length;i++) {
		             System.out.println(a[i]);
		         }
			break; 
		case 2: 
			for(int i = 0; i<a.length; i++){ 
				for(int j = i; j<a.length; j++){ 
					if(a[i].compareTo(a[j])<0) 
				{ 
				String aux = a[i]; 
				a[i] = a[j]; 
				a[j] = aux; 
						} 
					} 
				} 
			  System.out.println("DESCENDENTE");
		         for(int i=0;i<a.length;i++) {
		             System.out.println(a[i]);
		         }
			break; 
		case 3: 
			JOptionPane.showMessageDialog(null, "SALIENDO.....");
		break; 
		}
		}while(op!=3);
	}
}
