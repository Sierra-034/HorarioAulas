/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itsco.aulas.modelo.tablas;

import itsco.aulas.dao.DaoAula;
import itsco.aulas.modelo.Aula;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Samuel Gomez
 */
public class TableModelAula extends AbstractTableModel {
    
    private final String[] columnas = {"ID_AULA", "NUMERO_SILLAS"};
    private final DaoAula daoAula;
    private List<Aula> registros;

    public TableModelAula(DaoAula daoAula) {
        this.daoAula = daoAula;
        registros = new ArrayList<>();
    }
    
    public void loadData() {
        registros = daoAula.selectAll();
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
        Aula aulaSolicitada = registros.get(rowIndex);
        switch(columnIndex) {
            case 0: return aulaSolicitada.getIdAula();
            case 1: return aulaSolicitada.getNumeroSillas();
            
            default: return "undefined";
        }
    }
    
}
