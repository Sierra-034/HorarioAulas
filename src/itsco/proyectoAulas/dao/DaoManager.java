/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itsco.proyectoAulas.dao;

/**
 *
 * @author Samuel Gomez
 */
public interface DaoManager {
    
    DaoAula createDaoAula();
    DaoDocente createDaoDocente();
    DaoGrupo createDaoGrupo();
    DaoMateria createDaoMateria();
}
