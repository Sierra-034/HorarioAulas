/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itsco.proyectoAulas.dao.mariadb;

import itsco.proyectoAulas.dao.DaoMateria;
import itsco.proyectoAulas.modelo.Materia;
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
public class MariaDaoMateria implements DaoMateria{
    
    private final String[] COLUMNAS = {"ID_MATERIA", "NOMBRE", "CLAVE_MATERIA"};
    private final String INSERT = "INSERT INTO materias (NOMBRE, CLAVE_MATERIA) VALUES (?, ?)";
    private final String UPDATE = "UPDATE materias SET NOMBRE = ?, CLAVE_MATERIA = ? WHERE ID_MATERIA = ?";
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
            insertStatement.setString(1, elemento.getNombre());
            insertStatement.setString(2, elemento.getClaveMateria());
            insertStatement.executeUpdate();
            ResultSet rs = insertStatement.getGeneratedKeys();
            if(rs.next())
                elemento.setIdMateria(rs.getInt(COLUMNAS[0]));
            
        } catch (SQLException ex) {
            Logger.getLogger(MariaDaoMateria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Materia elemento) {
        try {
            PreparedStatement updateStatement = mariaConnection.prepareStatement(UPDATE);
            updateStatement.setString(1, elemento.getNombre());
            updateStatement.setString(2, elemento.getClaveMateria());
            updateStatement.setInt(3, elemento.getIdMateria());
            updateStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(MariaDaoMateria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Materia elemento) {
        try {
            PreparedStatement deleteStatement = mariaConnection.prepareStatement(DELETE);
            deleteStatement.setInt(1, elemento.getIdMateria());
            deleteStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(MariaDaoMateria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Materia select(Integer idElemento) {
        Materia materiasolicitada = null;
        
        try {
            PreparedStatement selectStatement = mariaConnection.prepareStatement(SELECT);
            selectStatement.setInt(1, idElemento);
            ResultSet rs = selectStatement.executeQuery();
            if(rs.next()) {
                String nombre = rs.getString(COLUMNAS[1]);
                String claveMateria = rs.getString(COLUMNAS[2]);
                materiasolicitada = new Materia(nombre, claveMateria);
                materiasolicitada.setIdMateria(idElemento);
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
                Integer idMateria = rs.getInt(COLUMNAS[0]);
                String nombre = rs.getString(COLUMNAS[1]);
                String claveMateria = rs.getString(COLUMNAS[2]);
                Materia materia = new Materia(nombre, claveMateria);
                materia.setIdMateria(idMateria);                
                registros.add(materia);
            }
                        
        } catch (SQLException ex) {
            Logger.getLogger(MariaDaoMateria.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return registros;        
    }
    
}
