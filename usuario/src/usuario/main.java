package usuario;

import javax.swing.JOptionPane;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		user[] usuario =  new user[4];
		System.out.println(); 
		do{
		usuario[0]= new user(JOptionPane.showInputDialog("Ingrese el correo: "));
		}while (usuario[0].verifica_correo(usuario[0].getCorreo())!=true); 
		do{
			usuario[1]= new user(JOptionPane.showInputDialog("Ingrese el correo: "));
			}while (usuario[1].verifica_correo(usuario[1].getCorreo())!=true);
		do{
			usuario[2]= new user(JOptionPane.showInputDialog("Ingrese el correo: "));
			}while (usuario[2].verifica_correo(usuario[2].getCorreo())!=true);
		do{
			usuario[3]= new user(JOptionPane.showInputDialog("Ingrese el correo: "));
			}while (usuario[3].verifica_correo(usuario[3].getCorreo())!=true);
		System.out.println("Su contraseña es: ");
		System.out.println(usuario[0].gen_Contraseña());
		System.out.println("Estado: ");
		if(usuario[0].es_fuerte(usuario[0].gen_Contraseña())==true){
		System.out.println("Fuerte");
		}else{
			System.out.println("No Fuerte");}
	}
}
