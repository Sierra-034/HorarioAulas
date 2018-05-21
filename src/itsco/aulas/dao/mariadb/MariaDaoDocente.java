/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itsco.aulas.dao.mariadb;

import itsco.aulas.dao.DaoDocente;
import itsco.aulas.modelo.Docente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Samuel Gomez
 */
class MariaDaoDocente implements DaoDocente{
    
    private final String[] COLUMNAS = {"ID_DOCENTE", "NOMBRE", "ACADEMIA"};
    private final String INSERT = "INSERT INTO docentes (NOMBRE, ACADEMIA) VALUES(?, ?)";
    private final String UPDATE = "UPDATE docentes SET NOMBRE = ?, ACADEMIA = ? WHERE ID_DOCENTE = ?";
    private final String DELETE = "DELETE FROM docentes WHERE ID_DOCENTE = ?";
    private final String SELECT = "SELECT * FROM docentes WHERE ID_DOCENTE = ?";
    private final String SELECT_ALL = "SELECT * FROM docentes";
    private final Connection mariaConnection;

    public MariaDaoDocente(Connection mariaConnection) {
        this.mariaConnection = mariaConnection;
    }

    @Override
    public void insert(Docente docente) {
        try {
            PreparedStatement insertStatement = mariaConnection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            insertStatement.setString(1, docente.getNombre());
            insertStatement.setString(2, docente.getAcademia());
            insertStatement.executeUpdate();
            ResultSet rs = insertStatement.getGeneratedKeys();
            if(rs.next())
                docente.setIdDocente(rs.getInt(COLUMNAS[0]));
            
        } catch (SQLException ex) {
            Logger.getLogger(MariaDaoDocente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Docente docente) {
        try {
            PreparedStatement updateStatement = mariaConnection.prepareStatement(UPDATE);
            updateStatement.setString(1, docente.getNombre());
            updateStatement.setString(2, docente.getAcademia());
            updateStatement.setInt(3, docente.getIdDocente());
            updateStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(MariaDaoDocente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Docente docente) {
        try {
            PreparedStatement deleteStatement = mariaConnection.prepareStatement(DELETE);
            deleteStatement.setInt(1, docente.getIdDocente());
            deleteStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(MariaDaoDocente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Docente select(Integer idDocente) {
        Docente docenteSolicitado = null;
        
        try {
            PreparedStatement selectStatement = mariaConnection.prepareStatement(SELECT);
            selectStatement.setInt(1, idDocente);
            ResultSet rs = selectStatement.executeQuery();
            if(rs.next()) {
                String nombre = rs.getString(COLUMNAS[1]);
                String academia = rs.getString(COLUMNAS[2]);
                docenteSolicitado = new Docente(nombre, academia);
                docenteSolicitado.setIdDocente(idDocente);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(MariaDaoDocente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return docenteSolicitado;
    }

    @Override
    public ArrayList<Docente> selectAll() {
        ArrayList<Docente> registros = new ArrayList<>();
        
        try {
            PreparedStatement selectAllStatement = mariaConnection.prepareStatement(SELECT_ALL);
            ResultSet rs = selectAllStatement.executeQuery();
            while(rs.next()) {
                Integer idDocente = rs.getInt(COLUMNAS[0]);
                String nombre = rs.getString(COLUMNAS[1]);
                String academia = rs.getString(COLUMNAS[2]);
                Docente docente = new Docente(nombre, academia);
                registros.add(docente);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MariaDaoDocente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return registros;
    }
    
}
