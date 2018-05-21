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
    
    private Integer idDocente;
    private String nombre;
    private String academia;

    public Docente(String nombre, String academia) {
        this.nombre = nombre;
        this.academia = academia;
    }

    public Integer getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(Integer idDocente) {
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
        String str = String.format("[%d, %s, %s]", idDocente, nombre, academia);
        return str;
    }
    
    
}
