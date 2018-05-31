/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itsco.aulas.dao;

import itsco.aulas.modelo.Horario;
import java.util.ArrayList;

/**
 *
 * @author Samuel Gomez
 */
public interface DaoHorario {
    
    ArrayList<Horario> selectByEdificio(String nombreEdificio);
    ArrayList<Horario> selectAll();
}
