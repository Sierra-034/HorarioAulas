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
public class Aula {
    
    private Integer idAula;
    private Integer numeroSillas;
    
    public Aula(int nSillas) {
        numeroSillas = nSillas;
    }

    public Integer getIdAula() {
        return idAula;
    }

    public void setIdAula(Integer idAula) {
        this.idAula = idAula;
    }

    public Integer getNumeroSillas() {
        return numeroSillas;
    }

    public void setNumeroSillas(Integer numeroSillas) {
        this.numeroSillas = numeroSillas;
    }

    @Override
    public String toString() {
        String str = String.format("[%d, %d]", idAula, numeroSillas);
        return str;
    }
    
}
