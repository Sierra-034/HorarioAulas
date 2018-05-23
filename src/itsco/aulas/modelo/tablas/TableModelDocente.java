/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itsco.aulas.modelo.tablas;

import itsco.aulas.dao.DaoDocente;
import itsco.aulas.modelo.Docente;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Samuel Gomez
 */
class TableModelDocente extends AbstractTableModel {
    
    private final String[] columnas = {"ID_DOCENTE", "NOMBRE", "ACADEMIA"};
    private final DaoDocente daoDocente;
    private List<Docente> registros;

    public TableModelDocente(DaoDocente daoDocente) {
        this.daoDocente = daoDocente;
        this.registros = new ArrayList<>();
    }
    
    public void loadData() {
        registros = daoDocente.selectAll();
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
        Docente docenteSolicitado = registros.get(rowIndex);
        switch(columnIndex) {
            case 0: return docenteSolicitado.getIdDocente();
            case 1: return docenteSolicitado.getNombre();
            case 2: return docenteSolicitado.getAcademia();
            
            default: return "undefined";
        }
    }
    
}
