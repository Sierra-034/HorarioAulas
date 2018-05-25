/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itsco.aulas.vista;

import itsco.aulas.modelo.tablas.TableModelFactory;
import itsco.aulas.modelo.tablas.TableModelMateria;
import itsco.aulas.modelo.tablas.TableNameConstant;
import itsco.aulas.vista.frames.ApplicationTables;

/**
 *
 * @author Samuel Gomez
 */
public class VistaMateria extends SuperPanel {
    
    private TableModelMateria modelMateria;

    public VistaMateria(ApplicationTables obs) {
        super(TableNameConstant.MATERIAS);
        initCustomComponents();
        initComponents();
        this.observer = obs;
        this.actualTable = tableMateria;
    }

    private void initCustomComponents() {
        modelMateria = TableModelFactory.getInstance().getTableModelMateria();
        modelMateria.loadData();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableMateria = new javax.swing.JTable();
        panelSur = new javax.swing.JPanel();
        labelIdMateria = new javax.swing.JLabel();
        fieldIdMateria = new javax.swing.JTextField();
        labelNombre = new javax.swing.JLabel();
        fieldNombre = new javax.swing.JTextField();

        setLayout(new java.awt.BorderLayout());

        tableMateria.setModel(modelMateria);
        jScrollPane1.setViewportView(tableMateria);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);

        panelSur.setLayout(new java.awt.GridLayout(2, 2));

        labelIdMateria.setText("ID MATERIA");
        panelSur.add(labelIdMateria);
        panelSur.add(fieldIdMateria);

        labelNombre.setText("NOMBRE");
        panelSur.add(labelNombre);
        panelSur.add(fieldNombre);

        add(panelSur, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField fieldIdMateria;
    private javax.swing.JTextField fieldNombre;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelIdMateria;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JPanel panelSur;
    private javax.swing.JTable tableMateria;
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
