/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Operaciones;


import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


/**
*
* @author Anthony Hernandez
*/


public class Conexion{
	Connection conexion;
	Statement consulta;

    /**
     * Constructor for objects of class Conexion
     */
    
    public void conectar(){
		try {
	            Class.forName("org.sqlite.JDBC");
	        }
	        catch (ClassNotFoundException e) {
	            JOptionPane.showMessageDialog(null, e.getMessage());
	        }	 
			try {
				            
                            conexion = DriverManager.getConnection("jdbc:sqlite:my_base_datos.db");
                            consulta = conexion.createStatement();                           
			} catch (SQLException e) {
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }
	}
    
}
