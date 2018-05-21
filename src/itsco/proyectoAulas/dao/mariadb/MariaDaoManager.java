/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itsco.proyectoAulas.dao.mariadb;

import itsco.proyectoAulas.dao.DaoAula;
import itsco.proyectoAulas.dao.DaoDocente;
import itsco.proyectoAulas.dao.DaoGrupo;
import itsco.proyectoAulas.dao.DaoManager;
import itsco.proyectoAulas.dao.DaoMateria;
import itsco.proyectoAulas.dao.mariadb.MariaDaoAula;
import itsco.proyectoAulas.dao.mariadb.MariaDaoDocente;
import itsco.proyectoAulas.dao.mariadb.MariaDaoGrupo;
import itsco.proyectoAulas.dao.mariadb.MariaDaoMateria;
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
    private final String CONNECTION_STRING = "jdbc:mariadb://localhost:3306/aulas";
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
