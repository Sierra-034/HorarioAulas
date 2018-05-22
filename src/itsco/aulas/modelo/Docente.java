/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itsco.aulas.modelo;

/**
 *
 * @author Samuel Gomez
 */
public class Docente {
    
    private String idDocente;
    private String nombre;
    private String academia;

    public Docente(String idDocente, String nombre, String academia) {
        this.idDocente = idDocente;
        this.nombre = nombre;
        this.academia = academia;
    }

    public String getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(String idDocente) {
        this.idDocente = idDocente;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAcademia() {
        return academia;
    }

    public void setAcademia(String academia) {
        this.academia = academia;
    }

    @Override
    public String toString() {
        return "Docente{" + "idDocente=" + idDocente + ", nombre=" + nombre + ", academia=" + academia + '}';
    }
       
}
