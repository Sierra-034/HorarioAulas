/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itsco.aulas.vista;

import itsco.aulas.modelo.tablas.TableModelDocente;
import itsco.aulas.modelo.tablas.TableModelFactory;
import itsco.aulas.modelo.tablas.TableNameConstant;

/**
 *
 * @author Samuel Gomez
 */
public class VistaDocente extends SuperPanel {
    
    private TableModelDocente modelDocente;

    public VistaDocente() {
        super(TableNameConstant.DOCENTES);
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
        tableDocente = new javax.swing.JTable();
        panelSur = new javax.swing.JPanel();
        labelIdDocente = new javax.swing.JLabel();
        fieldIdDocente = new javax.swing.JTextField();
        labelNombre = new javax.swing.JLabel();
        fieldNombre = new javax.swing.JTextField();
        labelAcademia = new javax.swing.JLabel();
        fieldAcademia = new javax.swing.JTextField();

        setLayout(new java.awt.BorderLayout());

        tableDocente.setModel(modelDocente);
        jScrollPane1.setViewportView(tableDocente);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);

        panelSur.setLayout(new java.awt.GridLayout(3, 2));

        labelIdDocente.setText("ID DOCENTE");
        panelSur.add(labelIdDocente);
        panelSur.add(fieldIdDocente);

        labelNombre.setText("NOMBRE");
        panelSur.add(labelNombre);
        panelSur.add(fieldNombre);

        labelAcademia.setText("ACADEMIA");
        panelSur.add(labelAcademia);
        panelSur.add(fieldAcademia);

        add(panelSur, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField fieldAcademia;
    private javax.swing.JTextField fieldIdDocente;
    private javax.swing.JTextField fieldNombre;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelAcademia;
    private javax.swing.JLabel labelIdDocente;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JPanel panelSur;
    private javax.swing.JTable tableDocente;
    // End of variables declaration//GEN-END:variables

}
