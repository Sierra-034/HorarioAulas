/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itsco.aulas.dao.mariadb;

import itsco.aulas.dao.DaoMateria;
import itsco.aulas.modelo.Materia;
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
class MariaDaoMateria implements DaoMateria{
    
    private final String[] COLUMNAS = {"ID_MATERIA", "NOMBRE"};
    private final String INSERT = "INSERT INTO materias (ID_MATERIA, NOMBRE) VALUES (?, ?)";
    private final String UPDATE = "UPDATE materias SET NOMBRE = ? WHERE ID_MATERIA = ?";
    private final String DELETE = "DELETE FROM materias WHERE ID_MATERIA = ?";
    private final String SELECT = "SELECT * FROM materias WHERE ID_MATERIA = ?";
    private final String SELECT_ALL = "SELECT * FROM materias";
    private final Connection mariaConnection;

    public MariaDaoMateria(Connection mariaConnection) {
        this.mariaConnection = mariaConnection;
    }

    @Override
    public void insert(Materia elemento) {
        try {
            PreparedStatement insertStatement = mariaConnection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            insertStatement.setString(1, elemento.getIdMateria());
            insertStatement.setString(2, elemento.getNombre());
            insertStatement.executeUpdate();
            ResultSet rs = insertStatement.getGeneratedKeys();
            if(rs.next())
                elemento.setIdMateria(rs.getString(COLUMNAS[0]));
            
        } catch (SQLException ex) {
            Logger.getLogger(MariaDaoMateria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Materia elemento) {
        try {
            PreparedStatement updateStatement = mariaConnection.prepareStatement(UPDATE);
            updateStatement.setString(1, elemento.getNombre());
            updateStatement.setString(2, elemento.getIdMateria());
            updateStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(MariaDaoMateria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Materia elemento) {
        try {
            PreparedStatement deleteStatement = mariaConnection.prepareStatement(DELETE);
            deleteStatement.setString(1, elemento.getIdMateria());
            deleteStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(MariaDaoMateria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Materia select(String idElemento) {
        Materia materiasolicitada = null;
        
        try {
            PreparedStatement selectStatement = mariaConnection.prepareStatement(SELECT);
            selectStatement.setString(1, idElemento);
            ResultSet rs = selectStatement.executeQuery();
            if(rs.next()) {
                String idMateria = rs.getString(COLUMNAS[0]);
                String nombre = rs.getString(COLUMNAS[1]);
                materiasolicitada = new Materia(idMateria, nombre);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(MariaDaoMateria.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return materiasolicitada;
    }

    @Override
    public ArrayList<Materia> selectAll() {
        ArrayList<Materia> registros = new ArrayList<>();
        
        try {
            PreparedStatement selectStatement = mariaConnection.prepareStatement(SELECT_ALL);
            ResultSet rs = selectStatement.executeQuery();
            while(rs.next()) {
                String idMateria = rs.getString(COLUMNAS[0]);
                String nombre = rs.getString(COLUMNAS[1]);
                Materia materia = new Materia(idMateria, nombre);               
                registros.add(materia);
            }
                        
        } catch (SQLException ex) {
            Logger.getLogger(MariaDaoMateria.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return registros;        
    }
    
}
