/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itsco.aulas.vista;

import itsco.aulas.modelo.tablas.TableModelFactory;
import itsco.aulas.modelo.tablas.TableModelGrupo;
import itsco.aulas.modelo.tablas.TableNameConstant;
import itsco.aulas.vista.frames.ApplicationTables;
import javafx.application.Application;

/**
 *
 * @author Samuel Gomez
 */
public class VistaGrupo extends SuperPanel {
    
    private TableModelGrupo modelGrupo;

    public VistaGrupo() {
        super(TableNameConstant.GRUPOS);
        initCustomComponents();
        initComponents();
        this.actualTable = tableGrupo;
    }

    private void initCustomComponents() {
        modelGrupo = TableModelFactory.getInstance().getTableModelGrupo();
        modelGrupo.loadData();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableGrupo = new javax.swing.JTable();
        panelSur = new javax.swing.JPanel();
        labelIdGrupo = new javax.swing.JLabel();
        fieldIdGrupo = new javax.swing.JTextField();
        labelNumeroAlumnos = new javax.swing.JLabel();
        fieldNumeroAlumnos = new javax.swing.JTextField();

        setLayout(new java.awt.BorderLayout());

        tableGrupo.setModel(modelGrupo);
        jScrollPane1.setViewportView(tableGrupo);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);

        panelSur.setLayout(new java.awt.GridLayout(2, 2));

        labelIdGrupo.setText("ID GRUPO");
        panelSur.add(labelIdGrupo);
        panelSur.add(fieldIdGrupo);

        labelNumeroAlumnos.setText("NÚMERO ALUMNOS");
        panelSur.add(labelNumeroAlumnos);
        panelSur.add(fieldNumeroAlumnos);

        add(panelSur, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField fieldIdGrupo;
    private javax.swing.JTextField fieldNumeroAlumnos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelIdGrupo;
    private javax.swing.JLabel labelNumeroAlumnos;
    private javax.swing.JPanel panelSur;
    private javax.swing.JTable tableGrupo;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionNuevo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionEditar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionBorrar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionGuardar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionCancelar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
