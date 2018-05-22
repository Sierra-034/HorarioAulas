/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itsco.aulas.dao.mariadb;

import itsco.aulas.dao.DaoAula;
import itsco.aulas.dao.DaoDocente;
import itsco.aulas.dao.DaoGrupo;
import itsco.aulas.dao.DaoManager;
import itsco.aulas.dao.DaoMateria;
import itsco.aulas.dao.mariadb.MariaDaoAula;
import itsco.aulas.dao.mariadb.MariaDaoDocente;
import itsco.aulas.dao.mariadb.MariaDaoGrupo;
import itsco.aulas.dao.mariadb.MariaDaoMateria;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Samuel Gomez
 */
public class MariaDaoManager implements DaoManager {
    
    private DaoAula daoAula;
    private DaoDocente daoDocente;
    private DaoGrupo daoGrupo;
    private DaoMateria daoMateria;
    
    private static DaoManager manager;
    private final String CONNECTION_STRING = "jdbc:mariadb://localhost:3306/horarioaulas";
    private final Connection mariaConnection;

    private MariaDaoManager(String user, String password) throws SQLException {
        mariaConnection = DriverManager.getConnection(CONNECTION_STRING, user, password);
    }
    
    public static DaoManager createMariaDaoManager(String user, String password) throws SQLException {
        if(manager == null)
            manager = new MariaDaoManager(user, password);
        
        return manager;
    }

    @Override
    public DaoAula createDaoAula() {
        if(daoAula == null)
            daoAula = new MariaDaoAula(mariaConnection);
        
        return daoAula;
    }

    @Override
    public DaoDocente createDaoDocente() {
        if(daoDocente == null)
            daoDocente = new MariaDaoDocente(mariaConnection);
        
        return daoDocente;
    }

    @Override
    public DaoGrupo createDaoGrupo() {
        if(daoGrupo == null)
            daoGrupo = new MariaDaoGrupo(mariaConnection);
        
        return daoGrupo;
    }

    @Override
    public DaoMateria createDaoMateria() {
        if(daoMateria == null)
            daoMateria = new MariaDaoMateria(mariaConnection);
        
        return daoMateria;
    }
    
}
