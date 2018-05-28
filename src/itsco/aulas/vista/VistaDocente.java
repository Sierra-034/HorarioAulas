/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itsco.aulas.vista;

import itsco.aulas.dao.DaoDocente;
import itsco.aulas.dao.mariadb.MariaDaoManager;
import itsco.aulas.modelo.Docente;
import itsco.aulas.modelo.tablas.TableModelDocente;
import itsco.aulas.modelo.tablas.TableModelFactory;
import itsco.aulas.modelo.tablas.TableNameConstant;
import itsco.aulas.vista.frames.ApplicationTables;
import javax.swing.JOptionPane;

/**
 *
 * @author Samuel Gomez
 */
public class VistaDocente extends SuperPanel {
    
    private final DaoDocente manager = MariaDaoManager.getInstance().createDaoDocente();
    private TableModelDocente modelDocente;
    private Docente singleDocente;

    public VistaDocente() {
        super(TableNameConstant.DOCENTES);
        initCustomComponents();
        initComponents();
        this.actualTable = tableDocente;
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

    public Docente getElementoSeleccionado() {
        String idDocente = (String) tableDocente.getValueAt(tableDocente.getSelectedRow(), 0);
        return manager.select(idDocente);
    }
    
    @Override
    public void actionNuevo() {
        singleDocente = null;
        fieldIdDocente.requestFocus();
    }

    @Override
    public void actionEditar() {
        singleDocente = getElementoSeleccionado();
        fieldIdDocente.setText(singleDocente.getIdDocente());
        fieldNombre.setText(singleDocente.getNombre());
        fieldAcademia.setText(singleDocente.getAcademia());
    }

    @Override
    public void actionBorrar() {
        String title = "Confirma borrado";
        String message = "Seguro que quieres borrar este Docente?";
        int optionPaneResult = JOptionPane.showConfirmDialog(this, message, title, 
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        
        if(optionPaneResult == JOptionPane.YES_OPTION) {
            Docente docenteSeleccionado = getElementoSeleccionado();
            manager.delete(docenteSeleccionado);
            modelDocente.loadData();
            modelDocente.fireTableDataChanged();
            clearTableSelection();
        }
    }

    @Override
    public void actionGuardar() {
        if(elementoValido()) {
            //Modifica elemento existente
            singleDocente.setIdDocente(fieldIdDocente.getText());
            singleDocente.setNombre(fieldNombre.getText());
            singleDocente.setAcademia(fieldAcademia.getText());
            manager.update(singleDocente);
        }
        else if(singleDocente == null) {
            //Guarda nuevo elemento
            String idDocente = fieldIdDocente.getText();
            String nombre = fieldNombre.getText();
            String academia = fieldAcademia.getText();
            Docente docenteNuevo = new Docente(idDocente, nombre, academia);
            manager.insert(docenteNuevo);
        }
        
        modelDocente.loadData();
        modelDocente.fireTableDataChanged();;
    }

    @Override
    public void actionCancelar() {
        fieldIdDocente.setText("");
        fieldNombre.setText("");
        fieldAcademia.setText("");
        singleDocente = null;
        clearTableSelection();
    }
    
    public boolean elementoValido() {
        boolean elemento = singleDocente != null; 
        boolean camposValidos = (fieldIdDocente.getText() != "") && 
                (fieldNombre.getText() != "") && 
                (fieldAcademia.getText() != "");
        return elemento && camposValidos;
    }

}
