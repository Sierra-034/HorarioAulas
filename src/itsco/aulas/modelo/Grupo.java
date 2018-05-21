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
    
    private Integer idGrupo;
    private Integer numeroAlumnos;
    private String claveCarrera;

    public Grupo(Integer numeroAlumnos, String claveCarrera) {
        this.numeroAlumnos = numeroAlumnos;
        this.claveCarrera = claveCarrera;
    }

    public Integer getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(Integer idGrupo) {
        this.idGrupo = idGrupo;
    }

    public Integer getNumeroAlumnos() {
        return numeroAlumnos;
    }

    public void setNumeroAlumnos(Integer numeroAlumnos) {
        this.numeroAlumnos = numeroAlumnos;
    }

    public String getClaveCarrera() {
        return claveCarrera;
    }

    public void setClaveCarrera(String claveCarrera) {
        this.claveCarrera = claveCarrera;
    }

    @Override
    public String toString() {
        return "Grupo{" + "idGrupo=" + idGrupo + ", numeroAlumnos=" + numeroAlumnos + ", claveCarrera=" + claveCarrera + '}';
    }
    
}
