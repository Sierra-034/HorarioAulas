/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itsco.proyectoAulas.modelo;

/**
 *
 * @author Samuel Gomez
 */
public class Materia {
    
    private Integer idMateria;
    private String nombre;
    private String claveMateria;

    public Materia(String nombre, String claveMateria) {
        this.nombre = nombre;
        this.claveMateria = claveMateria;
    }

    public Integer getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(Integer idMateria) {
        this.idMateria = idMateria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClaveMateria() {
        return claveMateria;
    }

    public void setClaveMateria(String claveMateria) {
        this.claveMateria = claveMateria;
    }

    @Override
    public String toString() {
        return "Materia{" + "idMateria=" + idMateria + ", nombre=" + nombre + ", claveMateria=" + claveMateria + '}';
    }
    
}
