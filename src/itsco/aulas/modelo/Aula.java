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
public class Aula {
    
    private String idAula;
    private String edificio;
    private Integer numeroSillas;
    
    public Aula(String idAula, String edificio, int nSillas) {
        this.idAula = idAula;
        this.edificio = edificio;
        numeroSillas = nSillas;
    }

    public String getIdAula() {
        return idAula;
    }

    public void setIdAula(String idAula) {
        this.idAula = idAula;
    }

    public String getEdificio() {
        return edificio;
    }

    public void setEdificio(String edificio) {
        this.edificio = edificio;
    }

    public Integer getNumeroSillas() {
        return numeroSillas;
    }

    public void setNumeroSillas(Integer numeroSillas) {
        this.numeroSillas = numeroSillas;
    }

    @Override
    public String toString() {
        return "Aula{" + "idAula=" + idAula + ", numeroSillas=" + numeroSillas + '}';
    }
    
    
}
