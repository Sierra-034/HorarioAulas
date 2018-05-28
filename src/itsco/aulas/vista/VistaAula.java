/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itsco.aulas.vista;

import itsco.aulas.dao.DaoAula;
import itsco.aulas.dao.mariadb.MariaDaoManager;
import itsco.aulas.modelo.Aula;
import itsco.aulas.modelo.tablas.TableModelAula;
import itsco.aulas.modelo.tablas.TableModelFactory;
import itsco.aulas.modelo.tablas.TableNameConstant;
import itsco.aulas.vista.frames.ApplicationTables;
import javax.swing.JOptionPane;

/**
 *
 * @author Samuel Gomez
 */
public class VistaAula extends SuperPanel {

    private final DaoAula manager = MariaDaoManager.getInstance().createDaoAula();
    private TableModelAula modelAula;
    private Aula singleAula;
    
    public VistaAula() {
        super(TableNameConstant.AULAS);
        initCustomComponents();
        initComponents();
        this.actualTable = tableAula;
    }
    
    private void initCustomComponents() {
        modelAula = TableModelFactory.getInstance().getTableModelAula();
        modelAula.loadData();
    }
    
    private Aula getElementoSeleccionado() {
        String idAula = (String) tableAula.getValueAt(tableAula.getSelectedRow(), 0);
        return manager.select(idAula);
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

    @Override
    public void actionNuevo() {
        singleAula = null;
        fieldIdAula.requestFocus();
    }

    @Override
    public void actionEditar() {
        singleAula = getElementoSeleccionado();
        fieldIdAula.setText(singleAula.getIdAula());
        fieldNumeroSillas.setText(singleAula.getNumeroSillas().toString());
    }

    @Override
    public void actionBorrar() {
        String title = "Confirma borrado";
        String message = "Seguro que quieres borrar esta Aula?";
        int optionPaneResult = JOptionPane.showConfirmDialog(this, message, title,
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        
        if(optionPaneResult == JOptionPane.YES_OPTION) {
            Aula aulaSeleccionada = getElementoSeleccionado();
            manager.delete(aulaSeleccionada);
            modelAula.loadData();
            modelAula.fireTableDataChanged();
        }
        
        modelAula.loadData();
        modelAula.fireTableDataChanged();
        tableAula.clearSelection();
    }

    @Override
    public void actionGuardar() {
        if(elementoValido()) {
            //Modificar elemento existente
            singleAula.setIdAula(fieldIdAula.getText());
            singleAula.setNumeroSillas(Integer.parseInt(fieldNumeroSillas.getText()));
            manager.update(singleAula);
        }
        else if(singleAula == null) {
            //Guardar nuevo elemento
            String idAula = fieldIdAula.getText();
            int numeroSillas = Integer.parseInt(fieldNumeroSillas.getText());
            Aula aulaNueva = new Aula(idAula, numeroSillas);
            manager.insert(aulaNueva);
        }
        
        modelAula.loadData();
        modelAula.fireTableDataChanged();
    }

    @Override
    public void actionCancelar() {
        fieldIdAula.setText("");
        fieldNumeroSillas.setText("");
        singleAula = null; 
        tableAula.clearSelection();
    }
    
    public boolean elementoValido() {
        boolean elemento = singleAula != null; 
        boolean camposValidos = (fieldIdAula.getText() != "") && (fieldNumeroSillas.getText() != "");
        return elemento && camposValidos;
    }

}
