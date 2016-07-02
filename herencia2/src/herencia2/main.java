package herencia2;
import javax.swing.JOptionPane;
public class main {

	public static void main(String[] args) {
    
    estudiante e1 = new estudiante("0802873067","9846");
    estudiante e2 = new estudiante("0802873067","Anthony","Hernandez","9456");
    estudiante e3 = new estudiante("Melvin","Gorozabel","Sistemas");
    estudiante e4 = new estudiante("Matias","Hernandez","08456522542","Esmeraldas","Sistemas","9571");
    
    e1.setNombres("Maria");
    e1.setApellidos("Marchan");
    e1.setCiudad("Esmeraldas");
    e1.setCarrera("Diseño"); 
    e1.verificar();
    
    e2.setCiudad("Manta");
    e2.setCarrera("Enfermeria"); 
    e2.verificar();

	e3.setCedula("855525141");
	e3.setCiudad("EL Carmen");
	e3.setCodigo("9452");
    e3.verificar();
	
    e4.verificar();
    
	}

}
