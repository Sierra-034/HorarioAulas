/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itsco.proyectoAulas.dao;

import itsco.proyectoAulas.modelo.Docente;
import java.util.ArrayList;

/**
 *
 * @author Samuel Gomez
 */
public interface DaoDocente {
    
    void insert(Docente docente);
    void update(Docente docente);
    void delete(Docente docente);
    Docente select(Integer idDocente);
    ArrayList<Docente> selectAll();
}
