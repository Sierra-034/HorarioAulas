/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itsco.aulas.dao.mariadb;

import itsco.aulas.dao.DaoHorario;
import itsco.aulas.modelo.Horario;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Samuel Gomez
 */
public class MariaDaoHorario implements DaoHorario {
    
    private final String SELECT_BY_EDIFICIO = "{call GENERATE_HORARIO_BY_EDIFICIO(?)}";
    private final String SELECT_ALL = "{call GENERATE_HORARIO()}";
    private Connection mariaConnection;

    public MariaDaoHorario(Connection mariaConnection) {
        this.mariaConnection = mariaConnection;
    }

    @Override
    public ArrayList<Horario> selectByEdificio(String nombreEdificio) {
        ArrayList<Horario> horarioByEdificio = new ArrayList<>();
        
        try {
            CallableStatement byEdificio = mariaConnection.prepareCall(SELECT_BY_EDIFICIO);
            byEdificio.setString(1, nombreEdificio);
            ResultSet rs = byEdificio.executeQuery();
            while(rs.next()) {
                Horario registro = new Horario();
                registro.setDocente(rs.getString("DOCENTE"));
                registro.setMateria(rs.getString("MATERIA"));
                registro.setAula(rs.getString("AULA"));
                registro.setGrupo(rs.getString("GRUPO"));
                registro.setHora(rs.getTime("HORA"));
                
                horarioByEdificio.add(registro);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MariaDaoHorario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return horarioByEdificio;
    }

    @Override
    public ArrayList<Horario> selectAll() {
        ArrayList<Horario> horarioByEdificio = new ArrayList<>();
        
        try {
            CallableStatement byEdificio = mariaConnection.prepareCall(SELECT_ALL);
            ResultSet rs = byEdificio.executeQuery();
            while(rs.next()) {
                Horario registro = new Horario();
                registro.setDocente(rs.getString("DOCENTE"));
                registro.setMateria(rs.getString("MATERIA"));
                registro.setAula(rs.getString("AULA"));
                registro.setGrupo(rs.getString("GRUPO"));
                registro.setHora(rs.getTime("HORA"));
                
                horarioByEdificio.add(registro);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MariaDaoHorario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return horarioByEdificio;
    }
    
}
