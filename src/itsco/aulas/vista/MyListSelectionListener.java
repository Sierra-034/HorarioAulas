/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itsco.aulas.vista;

import itsco.aulas.vista.frames.ApplicationTables;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Samuel Gomez
 */
public class MyListSelectionListener implements ListSelectionListener {
    
    private static MyListSelectionListener myListSelectionListener;
    private ApplicationTables mainApplicaton;

    private MyListSelectionListener(ApplicationTables mainApplicaton) {
        this.mainApplicaton = mainApplicaton;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        JTable table = mainApplicaton.getCurrentCenterPanel().getActualTable();
        boolean validSelection = (table.getSelectedRow() != -1);
        mainApplicaton.getButtonEditar().setEnabled(validSelection);
        mainApplicaton.getButtonBorrar().setEnabled(validSelection);
    }
    
    public static void createListSelectionListener(ApplicationTables mainApplication) {
        if(myListSelectionListener == null)
            myListSelectionListener = new MyListSelectionListener(mainApplication);
    }
    
    public static MyListSelectionListener getInstance() {
        return myListSelectionListener;
    }
    
}
