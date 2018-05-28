/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itsco.aulas.vista;

import itsco.aulas.vista.frames.ApplicationTables;
import javax.swing.JPanel;
import javax.swing.JTable;

/**
 *
 * @author Samuel Gomez
 */
public abstract class SuperPanel extends JPanel {
    
    protected String tableName;    
    protected ApplicationTables observer;
    protected JTable actualTable;

    public SuperPanel() {}

    public SuperPanel(String tableName) {
        this.tableName = tableName;
    }
    
    public void addListeners() { 
        actualTable.getSelectionModel().
                addListSelectionListener(MyListSelectionListener.getInstance());
    }
    
    public abstract void actionNuevo();
    public abstract void actionEditar();
    public abstract void actionBorrar();
    public abstract void actionGuardar();
    public abstract void actionCancelar();
    
    public void clearTableSelection() {
        actualTable.clearSelection();
    }

    public JTable getActualTable() {
        return actualTable;
    }

    @Override
    public String toString() {
        return tableName;
    }
}
