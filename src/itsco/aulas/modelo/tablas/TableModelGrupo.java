/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itsco.aulas.modelo.tablas;

import itsco.aulas.dao.DaoGrupo;
import itsco.aulas.modelo.Grupo;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Samuel Gomez
 */
class TableModelGrupo extends AbstractTableModel {
    
    private final String[] columnas = {"ID_GRUPO", "NUMERO_ALUMNOS"};
    private final DaoGrupo daoGrupo;
    private List<Grupo> registros;

    public TableModelGrupo(DaoGrupo daoGrupo) {
        this.daoGrupo = daoGrupo;
        registros = new ArrayList<>();
    }
    
    public void loadData() {
        registros = daoGrupo.selectAll();
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
        Grupo grupoSolicitado = registros.get(rowIndex);
        switch(columnIndex) {
            case 1: return grupoSolicitado.getIdGrupo();
            case 2: return grupoSolicitado.getNumeroAlumnos();
            
            default: return "undefined";
        }
    }
    
}
