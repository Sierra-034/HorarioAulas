/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itsco.aulas.dao.mariadb;

import itsco.aulas.dao.DaoGrupo;
import itsco.aulas.modelo.Grupo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Samuel Gomez
 */
class MariaDaoGrupo implements DaoGrupo{
    
    private final String[] COLUMNAS = {"ID_GRUPO", "NUMERO_ALUMNOS"};
    private final String INSERT = "INSERT INTO grupos (ID_GRUPO, NUMERO_ALUMNOS) VALUES (?, ?)";
    private final String UPDATE = "UPDATE grupos SET NUMERO_ALUMNOS = ? WHERE ID_GRUPO = ?";
    private final String DELETE = "DELETE FROM grupos WHERE ID_GRUPO = ?";
    private final String SELECT = "SELECT * FROM grupos WHERE ID_GRUPO = ?";
    private final String SELECT_ALL = "SELECT * FROM grupos";
    private final Connection mariaConnection;

    public MariaDaoGrupo(Connection mariaConnection) {
        this.mariaConnection = mariaConnection;
    }

    @Override
    public void insert(Grupo elemento) {
        try {
            PreparedStatement insertStatement = mariaConnection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            insertStatement.setString(1, elemento.getIdGrupo());
            insertStatement.setInt(2, elemento.getNumeroAlumnos());
            insertStatement.executeUpdate();
            ResultSet rs = insertStatement.getGeneratedKeys();
            if(rs.next())
                elemento.setIdGrupo(rs.getString(COLUMNAS[0]));
        } catch (SQLException ex) {
            Logger.getLogger(MariaDaoGrupo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Grupo elemento) {
        try {
            PreparedStatement updateStatement = mariaConnection.prepareStatement(UPDATE);
            updateStatement.setInt(1, elemento.getNumeroAlumnos());
            updateStatement.setString(2, elemento.getIdGrupo());
            updateStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(MariaDaoGrupo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Grupo elemento) {
        try {
            PreparedStatement deleteStatement = mariaConnection.prepareStatement(DELETE);
            deleteStatement.setString(1, elemento.getIdGrupo());
            deleteStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(MariaDaoGrupo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Grupo select(String idElemento) {
        Grupo grupoSolicitado = null;
        
        try {
            PreparedStatement selectStatement = mariaConnection.prepareStatement(SELECT);
            selectStatement.setString(1, idElemento);
            ResultSet rs = selectStatement.executeQuery();
            if(rs.next()) {
                Integer numeroAlumnos = rs.getInt(COLUMNAS[1]);
                grupoSolicitado = new Grupo(idElemento, numeroAlumnos);
                grupoSolicitado.setIdGrupo(idElemento);
            }
                
        } catch (SQLException ex) {
            Logger.getLogger(MariaDaoGrupo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return grupoSolicitado;
    }

    @Override
    public ArrayList<Grupo> selectAll() {
        ArrayList<Grupo> registros = new ArrayList<>();
        
        try {
            PreparedStatement selectAllStatement = mariaConnection.prepareStatement(SELECT_ALL);
            ResultSet rs = selectAllStatement.executeQuery();
            while(rs.next()) {
                String idGrupo = rs.getString(COLUMNAS[0]);
                Integer numeroAlumnos = rs.getInt(COLUMNAS[1]);
                Grupo grupo = new Grupo(idGrupo, numeroAlumnos);                
                registros.add(grupo);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(MariaDaoGrupo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return registros;
    }
    
}
