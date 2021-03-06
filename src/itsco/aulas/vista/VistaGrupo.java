/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itsco.aulas.vista;

import itsco.aulas.dao.DaoGrupo;
import itsco.aulas.dao.mariadb.MariaDaoManager;
import itsco.aulas.modelo.Grupo;
import itsco.aulas.modelo.tablas.TableModelFactory;
import itsco.aulas.modelo.tablas.TableModelGrupo;
import itsco.aulas.modelo.tablas.TableNameConstant;
import javax.swing.JOptionPane;

/**
 *
 * @author Samuel Gomez
 */
public class VistaGrupo extends SuperPanel {
    
    private final DaoGrupo manager = MariaDaoManager.getInstance().createDaoGrupo();
    private TableModelGrupo modelGrupo;
    private Grupo singleGrupo;

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
    
    private Grupo getElementoSeleccionado() {
        String idGrupo = (String) tableGrupo.getValueAt(tableGrupo.getSelectedRow(), 0);
        return manager.select(idGrupo);
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
        singleGrupo = null;
        fieldIdGrupo.requestFocus();
    }

    @Override
    public void actionEditar() {
        singleGrupo = getElementoSeleccionado();
        fieldIdGrupo.setText(singleGrupo.getIdGrupo());
        fieldNumeroAlumnos.setText(singleGrupo.getNumeroAlumnos().toString());
    }

    @Override
    public void actionBorrar() {
        String title = "Confirma borrado";
        String message = "Seguro que quieres borrar este Grupo?";
        int optionPaneResult = JOptionPane.showConfirmDialog(this, message, title,
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        
        if(optionPaneResult == JOptionPane.YES_OPTION) {
            Grupo grupoSeleccionado = getElementoSeleccionado();
            manager.delete(grupoSeleccionado);
            modelGrupo.loadData();
            modelGrupo.fireTableDataChanged();        
            clearTableSelection();
        }
    }

    @Override
    public void actionGuardar() {
        if(elementoValido()) {
            //Modificar elemento existente
            singleGrupo.setIdGrupo(fieldIdGrupo.getText());
            singleGrupo.setNumeroAlumnos(Integer.parseInt(fieldNumeroAlumnos.getText()));
            manager.update(singleGrupo);
        }
        else if(singleGrupo == null) {
            //Guardar nuevo elemento
            String idGrupo = fieldIdGrupo.getText();
            int numeroAlumnos = Integer.parseInt(fieldNumeroAlumnos.getText());
            Grupo grupoNuevo = new Grupo(idGrupo, numeroAlumnos);
            manager.insert(grupoNuevo);
        }
        
        modelGrupo.loadData();
        modelGrupo.fireTableDataChanged();        
    }

    @Override
    public void actionCancelar() {
        fieldIdGrupo.setText("");
        fieldNumeroAlumnos.setText("");
        singleGrupo = null; 
        clearTableSelection();
    }
    
    public boolean elementoValido() {
        boolean elemento = singleGrupo != null; 
        boolean camposValidos = (fieldIdGrupo.getText() != "") && (fieldNumeroAlumnos.getText() != "");
        return elemento && camposValidos;
    }

}
