/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itsco.proyectoAulas.dao.mariadb;

import itsco.proyectoAulas.dao.DaoAula;
import itsco.proyectoAulas.modelo.Aula;
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
class MariaDaoAula implements DaoAula{
    
    private final String[] COLUMNAS = {"ID_AULA", "NUMERO_SILLAS"};
    private final String INSERT = "INSERT INTO aulas (NUMERO_SILLAS) VALUES (?)";
    private final String UPDATE = "UPDATE aulas SET NUMERO_SILLAS = ? WHERE ID_AULA = ?";
    private final String DELETE = "DELETE FROM aulas WHERE ID_AULA = ?";
    private final String SELECT = "SELECT * FROM aulas WHERE ID_AULA = ?";
    private final String SELECT_ALL = "SELECT * FROM aulas";
    private final Connection mariaConnection;

    public MariaDaoAula(Connection mariaConnection) {
        this.mariaConnection = mariaConnection;
    }

    @Override
    public void insert(Aula aula) {
        try {
            PreparedStatement insertStatement = mariaConnection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            insertStatement.setInt(1, aula.getNumeroSillas());
            insertStatement.executeUpdate();
            ResultSet generatedKeys = insertStatement.getGeneratedKeys();
            if(generatedKeys.next())
                aula.setIdAula(generatedKeys.getInt(COLUMNAS[0]));
            
        } catch (SQLException ex) {
            Logger.getLogger(MariaDaoAula.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Aula aula) {
        try {
            PreparedStatement updateStatment = mariaConnection.prepareStatement(UPDATE);
            updateStatment.setInt(1, aula.getNumeroSillas());
            updateStatment.setInt(2, aula.getIdAula());
            updateStatment.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(MariaDaoAula.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Aula aula) {
        try {
            PreparedStatement deleteStatement = mariaConnection.prepareStatement(DELETE);
            deleteStatement.setInt(1, aula.getIdAula());
            deleteStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(MariaDaoAula.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Aula select(Integer idAula) {
        Aula aulaSolicitada = null;
        
        try {
            PreparedStatement selectStatement = mariaConnection.prepareStatement(SELECT);
            selectStatement.setInt(1, idAula);
            ResultSet rs = selectStatement.executeQuery();
            
            if(rs.next()) {
                Integer numeroSillas = rs.getInt(COLUMNAS[1]);
                aulaSolicitada = new Aula(numeroSillas);
                aulaSolicitada.setIdAula(idAula);
            }
                
        } catch (SQLException ex) {
            Logger.getLogger(MariaDaoAula.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return aulaSolicitada;
    }

    @Override
    public ArrayList<Aula> selectAll() {
        ArrayList<Aula> registros = new ArrayList<>();
        
        try {
            PreparedStatement selectAllStatement = mariaConnection.prepareStatement(SELECT_ALL);
            ResultSet rs = selectAllStatement.executeQuery();
            while(rs.next()) {
                Integer idAula = rs.getInt(COLUMNAS[0]);
                Integer numeroSillas = rs.getInt(COLUMNAS[1]);
                Aula aulaListada = new Aula(numeroSillas);
                aulaListada.setIdAula(idAula);
                registros.add(aulaListada);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(MariaDaoAula.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return registros;
    }
    
}
