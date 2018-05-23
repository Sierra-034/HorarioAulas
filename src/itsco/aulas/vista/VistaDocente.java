/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itsco.aulas.vista;

import itsco.aulas.modelo.tablas.TableModelDocente;
import itsco.aulas.modelo.tablas.TableModelFactory;

/**
 *
 * @author Samuel Gomez
 */
public class VistaDocente extends javax.swing.JPanel {
    
    private TableModelDocente modelDocente;

    public VistaDocente() {
        initCustomComponents();
        initComponents();
    }

    private void initCustomComponents() {
        modelDocente = TableModelFactory.getInstance().getTableModelDocente();
        modelDocente.loadData();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setLayout(new java.awt.BorderLayout());

        jTable1.setModel(modelDocente);
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

}
