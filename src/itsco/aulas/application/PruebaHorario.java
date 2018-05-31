/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itsco.aulas.application;

import itsco.aulas.dao.DaoHorario;
import itsco.aulas.dao.DaoManager;
import itsco.aulas.dao.mariadb.MariaDaoManager;
import itsco.aulas.modelo.Horario;
import java.util.ArrayList;

/**
 *
 * @author Samuel Gomez
 */
public class PruebaHorario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DaoManager manager = MariaDaoManager.createMariaDaoManager("root", "123");
        DaoHorario daoHorario = manager.createDaoHorario();
        ArrayList<Horario> registros = daoHorario.selectAll();
        registros.forEach(System.out::println);
    }
    
}
