/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rec;

/**
 *
 * 
 */
import java.io.Serializable;

public class Alumno extends Lista implements Serializable {

    private int matricula;
    private String nombre;
    private String materia;
    private double nota_total;
    private double nota_exa;

    public Alumno() {

    }

    public Alumno(int matricula, String nombre, String genero, double nota_total, double nota_exa) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.materia = genero;
        this.nota_total = nota_total;
        this.nota_exa = nota_exa;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public double getNota_total() {
        return nota_total;
    }

    public void setNota_total(double nota_total) {
        this.nota_total = nota_total;
    }

    public double getNota_exa() {
        return nota_exa;
    }

    public void setNota_exa(double nota_exa) {
        this.nota_exa = nota_exa;
    }

    public double getPromedio() {
        return nota_exa + nota_total;
    }

    public void info() {
        System.out.println("Matricula: " + getMatricula() + " Nombre: " + getNombre() + " Materia: " + getMateria() + " Nota Total: " + getNota_total() + " Nota Examen: " + getNota_exa());
    }

    
    }

