/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itsco.proyectoAulas.dao;

import itsco.proyectoAulas.modelo.Aula;
import java.util.ArrayList;

/**
 *
 * @author Samuel Gomez
 */
public interface DaoAula {
    
    void insert(Aula aula);
    void update(Aula aula);
    void delete(Aula aula);
    Aula select(Integer idAula);
    ArrayList<Aula> selectAll();
}
