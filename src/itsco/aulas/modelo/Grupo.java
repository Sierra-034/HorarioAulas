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
public class Grupo {
    
    private String idGrupo;
    private Integer numeroAlumnos;

    public Grupo(Integer numeroAlumnos) {
        this.numeroAlumnos = numeroAlumnos;
    }

    public String getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(String idGrupo) {
        this.idGrupo = idGrupo;
    }

    public Integer getNumeroAlumnos() {
        return numeroAlumnos;
    }

    public void setNumeroAlumnos(Integer numeroAlumnos) {
        this.numeroAlumnos = numeroAlumnos;
    }

    @Override
    public String toString() {
        return "Grupo{" + "idGrupo=" + idGrupo + ", numeroAlumnos=" + numeroAlumnos + '}';
    }
    
}
