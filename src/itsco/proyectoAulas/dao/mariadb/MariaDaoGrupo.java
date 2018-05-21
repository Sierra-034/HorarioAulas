/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itsco.proyectoAulas.dao.mariadb;

import itsco.proyectoAulas.dao.DaoGrupo;
import itsco.proyectoAulas.modelo.Grupo;
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
class MariaDaoGrupo implements DaoGrupo{
    
    private final String[] COLUMNAS = {"ID_GRUPO", "NUMERO_ALUMNOS", "CLAVE_CARRERA"};
    private final String INSERT = "INSERT INTO grupos (NUMERO_ALUMNOS, CLAVE_CARRERA) VALUES (?, ?)";
    private final String UPDATE = "UPDATE grupos SET NUMERO_ALUMNOS = ?, CLAVE_CARRERA = ? WHERE ID_GRUPO = ?";
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
            insertStatement.setInt(1, elemento.getNumeroAlumnos());
            insertStatement.setString(2, elemento.getClaveCarrera());
            insertStatement.executeUpdate();
            ResultSet rs = insertStatement.getGeneratedKeys();
            if(rs.next())
                elemento.setIdGrupo(rs.getInt(UPDATE));
        } catch (SQLException ex) {
            Logger.getLogger(MariaDaoGrupo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Grupo elemento) {
        try {
            PreparedStatement updateStatement = mariaConnection.prepareStatement(UPDATE);
            updateStatement.setInt(1, elemento.getNumeroAlumnos());
            updateStatement.setString(2, elemento.getClaveCarrera());
            updateStatement.setInt(3, elemento.getIdGrupo());
            updateStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(MariaDaoGrupo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Grupo elemento) {
        try {
            PreparedStatement deleteStatement = mariaConnection.prepareStatement(DELETE);
            deleteStatement.setInt(1, elemento.getIdGrupo());
            deleteStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(MariaDaoGrupo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Grupo select(Integer idElemento) {
        Grupo grupoSolicitado = null;
        
        try {
            PreparedStatement selectStatement = mariaConnection.prepareCall(SELECT);
            selectStatement.setInt(1, idElemento);
            ResultSet rs = selectStatement.executeQuery();
            if(rs.next()) {
                Integer numeroAlumnos = rs.getInt(COLUMNAS[1]);
                String claveMateria = rs.getString(COLUMNAS[2]);
                grupoSolicitado = new Grupo(numeroAlumnos, claveMateria);
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
            PreparedStatement selectAllStatement = mariaConnection.prepareCall(SELECT_ALL);
            ResultSet rs = selectAllStatement.executeQuery();
            while(rs.next()) {
                Integer idGrupo = rs.getInt(COLUMNAS[0]);
                Integer numeroAlumnos = rs.getInt(COLUMNAS[1]);
                String claveCarrera = rs.getString(COLUMNAS[2]);
                Grupo grupo = new Grupo(numeroAlumnos, claveCarrera);
                grupo.setIdGrupo(idGrupo);                
                registros.add(grupo);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(MariaDaoGrupo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return registros;
    }
    
}
