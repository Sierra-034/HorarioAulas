/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itsco.aulas.application;

import itsco.aulas.dao.DaoDocente;
import itsco.aulas.dao.DaoManager;
import itsco.aulas.dao.mariadb.MariaDaoManager;
import itsco.aulas.modelo.Docente;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Samuel Gomez
 */
public class PruebaDocentes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        DaoManager manager = MariaDaoManager.createMariaDaoManager("root", "123");
        DaoDocente daoAulas = manager.createDaoDocente();
        List<Docente> registros = daoAulas.selectAll();
        registros.forEach(System.out::println);
    }
    
}
