/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itsco.aulas.vista;

import itsco.aulas.dao.DaoMateria;
import itsco.aulas.dao.mariadb.MariaDaoManager;
import itsco.aulas.modelo.Materia;
import itsco.aulas.modelo.tablas.TableModelFactory;
import itsco.aulas.modelo.tablas.TableModelMateria;
import itsco.aulas.modelo.tablas.TableNameConstant;
import itsco.aulas.vista.frames.ApplicationTables;
import javax.swing.JOptionPane;

/**
 *
 * @author Samuel Gomez
 */
public class VistaMateria extends SuperPanel {
    
    private final DaoMateria manager = MariaDaoManager.getInstance().createDaoMateria();
    private TableModelMateria modelMateria;
    private Materia singleMateria;

    public VistaMateria() {
        super(TableNameConstant.MATERIAS);
        initCustomComponents();
        initComponents();
        this.actualTable = tableMateria;
    }

    private void initCustomComponents() {
        modelMateria = TableModelFactory.getInstance().getTableModelMateria();
        modelMateria.loadData();
    }
    
    private Materia getElementoSeleccionado() {
        String idAula = (String) tableMateria.getValueAt(tableMateria.getSelectedRow(), 0);
        return manager.select(idAula);
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
        singleMateria = null;
        fieldIdMateria.requestFocus();
    }

    @Override
    public void actionEditar() {
        singleMateria = getElementoSeleccionado();
        fieldIdMateria.setText(singleMateria.getIdMateria());
        fieldNombre.setText(singleMateria.getNombre());
    }

    @Override
    public void actionBorrar() {
        String title = "Confirma borrado";
        String message = "Seguro que quieres borrar esta Aula?";
        int optionPaneResult = JOptionPane.showConfirmDialog(this, message, title,
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        
        if(optionPaneResult == JOptionPane.YES_OPTION) {
            Materia materiaSeleccionada = getElementoSeleccionado();
            manager.delete(materiaSeleccionada);
            modelMateria.loadData();
            modelMateria.fireTableDataChanged();        
            clearTableSelection();
        }
    }

    @Override
    public void actionGuardar() {
        if(elementoValido()) {
            //Modificar elemento existente
            singleMateria.setIdMateria(fieldIdMateria.getText());
            singleMateria.setNombre(fieldNombre.getText());
            manager.update(singleMateria);
        }
        else if(singleMateria == null) {
            //Guardar nuevo elemento
            String idMateria = fieldIdMateria.getText();
            String nombre = fieldNombre.getText();
            Materia materiaNueva = new Materia(idMateria, nombre);
            manager.insert(materiaNueva);
        }
        
        modelMateria.loadData();
        modelMateria.fireTableDataChanged();
    }

    @Override
    public void actionCancelar() {
        fieldIdMateria.setText("");
        fieldNombre.setText("");
        singleMateria = null; 
        clearTableSelection();
    }

    private boolean elementoValido() {
        boolean elemento = singleMateria != null; 
        boolean camposValidos = (fieldIdMateria.getText() != "") && (fieldNombre.getText() != "");
        return elemento && camposValidos;
    }

}
