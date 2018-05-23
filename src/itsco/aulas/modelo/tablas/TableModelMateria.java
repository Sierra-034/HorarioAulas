/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itsco.aulas.modelo.tablas;

import itsco.aulas.dao.DaoMateria;
import itsco.aulas.modelo.Materia;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Samuel Gomez
 */
public class TableModelMateria extends AbstractTableModel {
    
    private final String[] columnas = {"ID_MATERIA", "NOMBRE"};
    private final DaoMateria daoMateria;
    private List<Materia> registros;

    public TableModelMateria(DaoMateria daoMateria) {
        this.daoMateria = daoMateria;
        registros = new ArrayList<>();
    }
    
    public void loadData() {
        registros = daoMateria.selectAll();
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
        Materia materiaSolicitada = registros.get(rowIndex);
        switch(columnIndex) { 
            case 0: return materiaSolicitada.getIdMateria();
            case 1: return materiaSolicitada.getNombre();
            
            default: return "undefined";
        }
    }
    
}
