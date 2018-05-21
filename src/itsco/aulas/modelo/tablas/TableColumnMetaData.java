/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itsco.aulas.modelo.tablas;

/**
 *
 * @author Samuel Gomez
 */
public class TableColumnMetaData {
    
    private int ordinalPosition;
    private String columnName;

    public TableColumnMetaData(int ordinalPosition, String columnName) {
        this.ordinalPosition = ordinalPosition;
        this.columnName = columnName;
    }

    public int getOrdinalPosition() {
        return ordinalPosition;
    }

    public String getColumnName() {
        return columnName;
    }
    
    
}
