/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itsco.aulas.dao.mariadb;

import itsco.aulas.dao.DaoAula;
import itsco.aulas.modelo.Aula;
import java.sql.CallableStatement;
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
    
    private final String[] COLUMNAS = {"ID_AULA", "EDIFICIO", "NUMERO_SILLAS"};
    private final String INSERT = "INSERT INTO aulas (ID_AULA, EDIFICIO, NUMERO_SILLAS) VALUES (?, ?, ?)";
    private final String UPDATE = "UPDATE aulas SET EDIFICIO = ?, NUMERO_SILLAS = ? WHERE ID_AULA = ?";
    private final String DELETE = "DELETE FROM aulas WHERE ID_AULA = ?";
    private final String SELECT = "SELECT * FROM aulas WHERE ID_AULA = ?";
    private final String SELECT_ALL = "SELECT * FROM aulas";
    private final String SELECT_EDIFICIOS = "{call EDIFICIOS_FROM_AULAS()}";
    private final String SELECT_AULA_BY_EDIFICIO = "{call AULA_BY_EDIFICIO(?)}";
    private final Connection mariaConnection;

    public MariaDaoAula(Connection mariaConnection) {
        this.mariaConnection = mariaConnection;
    }

    @Override
    public void insert(Aula aula) {
        try {
            PreparedStatement insertStatement = mariaConnection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            insertStatement.setString(1, aula.getIdAula());
            insertStatement.setString(2, aula.getEdificio());
            insertStatement.setInt(3, aula.getNumeroSillas());
            insertStatement.executeUpdate();
            ResultSet generatedKeys = insertStatement.getGeneratedKeys();
            if(generatedKeys.next())
                aula.setIdAula(generatedKeys.getString(COLUMNAS[0]));
            
        } catch (SQLException ex) {
            Logger.getLogger(MariaDaoAula.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Aula aula) {
        try {
            PreparedStatement updateStatment = mariaConnection.prepareStatement(UPDATE);
            updateStatment.setString(1, aula.getEdificio());
            updateStatment.setInt(2, aula.getNumeroSillas());
            updateStatment.setString(3, aula.getIdAula());
            updateStatment.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(MariaDaoAula.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Aula aula) {
        try {
            PreparedStatement deleteStatement = mariaConnection.prepareStatement(DELETE);
            deleteStatement.setString(1, aula.getIdAula());
            deleteStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(MariaDaoAula.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Aula select(String idAula) {
        Aula aulaSolicitada = null;
        
        try {
            PreparedStatement selectStatement = mariaConnection.prepareStatement(SELECT);
            selectStatement.setString(1, idAula);
            ResultSet rs = selectStatement.executeQuery();
            
            if(rs.next()) {
                String edificio = rs.getString(COLUMNAS[1]);
                Integer numeroSillas = rs.getInt(COLUMNAS[2]);
                aulaSolicitada = new Aula(idAula, edificio, numeroSillas);
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
                String idAula = rs.getString(COLUMNAS[0]);
                String edificio = rs.getString(COLUMNAS[1]);
                Integer numeroSillas = rs.getInt(COLUMNAS[2]);
                Aula aulaListada = new Aula(idAula, edificio, numeroSillas);
                registros.add(aulaListada);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(MariaDaoAula.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return registros;
    }

    @Override
    public ArrayList<String> selectEdificios() {
        ArrayList<String> edificios = new ArrayList<>();
        
        try {
            CallableStatement getEdificios = mariaConnection.prepareCall(SELECT_EDIFICIOS);
            ResultSet rs = getEdificios.executeQuery();
            while(rs.next()) {
                String nombreEdificio = rs.getString("EDIFICIO");
                edificios.add(nombreEdificio);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MariaDaoAula.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return edificios;
    }

    @Override
    public ArrayList<String> aulaByEdificio(String nombreEdificio) {
        ArrayList<String> aulas = new ArrayList<>();
        
        try {
            CallableStatement getAulas = mariaConnection.prepareCall(SELECT_AULA_BY_EDIFICIO);
            getAulas.setString(1, nombreEdificio);
            ResultSet rs = getAulas.executeQuery();
            while(rs.next()) {
                String nombreAula = rs.getString("ID_AULA");
                aulas.add(nombreAula);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MariaDaoAula.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return aulas;
    }
    
}
