/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itsco.aulas.modelo.tablas;

import itsco.aulas.dao.DaoHorario;
import itsco.aulas.modelo.Horario;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Samuel Gomez
 */
public class TableModelHorario extends AbstractTableModel {
    
    private final String[] columnas = {"DOCENTE", "MATERIA", "AULA", "GRUPO", "HORA"};
    private final DaoHorario daoHorario;
    private List<Horario> registros;

    public TableModelHorario(DaoHorario daoHorario) {
        this.daoHorario = daoHorario;
    }
    
    public void loadData() {
        registros = daoHorario.selectAll();
    }
    
    public void loadDataByEdificio(String nombreEdificio) {
        registros = daoHorario.selectByEdificio(nombreEdificio);
    }

    @Override
    public int getRowCount() {
        return registros.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Horario registro = registros.get(rowIndex);
        switch(columnIndex) {
            case 0: return registro.getDocente();
            case 1: return registro.getMateria();
            case 2: return registro.getAula();
            case 3: return registro.getGrupo();
            case 4: return registro.getHora();
            
            default: return "undefined";
        }
    }
    
}
