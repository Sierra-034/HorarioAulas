/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itsco.aulas.modelo;

import java.sql.Time;

/**
 *
 * @author Samuel Gomez
 */
public class Horario {

    private String docente;
    private String materia;
    private String aula;
    private String grupo;
    private Time hora;

    public Horario() {}

    public String getDocente() {
        return docente;
    }

    public void setDocente(String docente) {
        this.docente = docente;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getAula() {
        return aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    @Override
    public String toString() {
        return "Horario{" + "docente=" + docente + ", materia=" + materia + ", aula=" + aula + ", grupo=" + grupo + ", hora=" + hora + '}';
    }
}
