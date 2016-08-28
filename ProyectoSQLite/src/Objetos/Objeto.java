/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

/**
 *
 * @author Anthony Hernandez
 */
public class Objeto {
    private String id;
    private String nombre;
    private String stock;
    private String fecha;
    
    
    
    public Objeto(String id, String nombre, String stock,String fecha) {
        this.id = id;
        this.nombre = nombre;
        this.stock = stock;
        this.fecha=fecha; 
    }

    public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    
    public String getnombre() {
        return nombre;
    }

    public void setnombre(String nombre) {
        this.nombre = nombre;
    }

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

    
    
}
