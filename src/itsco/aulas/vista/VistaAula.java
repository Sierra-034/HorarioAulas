/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itsco.aulas.vista;

import itsco.aulas.modelo.Aula;
import itsco.aulas.modelo.tablas.TableModelAula;
import itsco.aulas.modelo.tablas.TableModelFactory;
import itsco.aulas.modelo.tablas.TableNameConstant;

/**
 *
 * @author Samuel Gomez
 */
public class VistaAula extends SuperPanel {

    private TableModelAula modelAula;
    
    public VistaAula() {
        super(TableNameConstant.AULAS);
        initCustomComponents();
        initComponents();
    }
    
    private void initCustomComponents() {
        modelAula = TableModelFactory.getInstance().getTableModelAula();
        modelAula.loadData();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableAula = new javax.swing.JTable();
        panelSur = new javax.swing.JPanel();
        labelIdAula = new javax.swing.JLabel();
        fieldIdAula = new javax.swing.JTextField();
        labelNumeroSillas = new javax.swing.JLabel();
        fieldNumeroSillas = new javax.swing.JTextField();

        setLayout(new java.awt.BorderLayout());

        tableAula.setModel(modelAula);
        jScrollPane1.setViewportView(tableAula);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);

        panelSur.setLayout(new java.awt.GridLayout(2, 2, 5, 0));

        labelIdAula.setText("ID AULA");
        labelIdAula.setName(""); // NOI18N
        panelSur.add(labelIdAula);
        panelSur.add(fieldIdAula);

        labelNumeroSillas.setText("NUMERO SILLAS");
        panelSur.add(labelNumeroSillas);
        panelSur.add(fieldNumeroSillas);

        add(panelSur, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField fieldIdAula;
    private javax.swing.JTextField fieldNumeroSillas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelIdAula;
    private javax.swing.JLabel labelNumeroSillas;
    private javax.swing.JPanel panelSur;
    private javax.swing.JTable tableAula;
    // End of variables declaration//GEN-END:variables

}
