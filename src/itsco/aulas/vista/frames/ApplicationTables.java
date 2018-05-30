/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itsco.aulas.vista.frames;

import itsco.aulas.dao.DaoManager;
import itsco.aulas.dao.mariadb.MariaDaoManager;
import itsco.aulas.modelo.tablas.TableModelFactory;
import itsco.aulas.modelo.tablas.TableNameConstant;
import itsco.aulas.vista.MyListSelectionListener;
import itsco.aulas.vista.SuperPanel;
import itsco.aulas.vista.VistaAula;
import itsco.aulas.vista.VistaDocente;
import itsco.aulas.vista.VistaGrupo;
import itsco.aulas.vista.VistaMateria;
import java.awt.CardLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Samuel Gomez
 */
public final class ApplicationTables extends javax.swing.JFrame implements ItemListener {
    
    private SuperPanel currentCenterPanel;
    private final SuperPanel panelAula = new VistaAula();
    private final SuperPanel panelDocente = new VistaDocente();
    private final SuperPanel panelGrupo = new VistaGrupo();
    private final SuperPanel panelMateria = new VistaMateria();
    private DefaultComboBoxModel<SuperPanel> comboBoxModel;

    public ApplicationTables() { 
        super("Horario Aulas");
        initCustomComponents();
        initComponents();
        addPanelsToCenterPanel();
        addListeners();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        northPanel = new javax.swing.JPanel();
        toolBar = new javax.swing.JToolBar();
        buttonNuevo = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        buttonEditar = new javax.swing.JButton();
        buttonBorrar = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        buttonGuardar = new javax.swing.JButton();
        buttonCancelar = new javax.swing.JButton();
        cbTableChooser = new javax.swing.JComboBox<>();
        centerPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        northPanel.setLayout(new java.awt.GridLayout(2, 0));

        toolBar.setRollover(true);

        buttonNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/anadir.png"))); // NOI18N
        buttonNuevo.setText("Nuevo");
        buttonNuevo.setFocusable(false);
        buttonNuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonNuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNuevoActionPerformed(evt);
            }
        });
        toolBar.add(buttonNuevo);

        jSeparator1.setOpaque(true);
        toolBar.add(jSeparator1);

        buttonEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/editar.png"))); // NOI18N
        buttonEditar.setText("Editar");
        buttonEditar.setEnabled(false);
        buttonEditar.setFocusable(false);
        buttonEditar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonEditar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditarActionPerformed(evt);
            }
        });
        toolBar.add(buttonEditar);

        buttonBorrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/menos.png"))); // NOI18N
        buttonBorrar.setText("Borrar");
        buttonBorrar.setEnabled(false);
        buttonBorrar.setFocusable(false);
        buttonBorrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonBorrar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBorrarActionPerformed(evt);
            }
        });
        toolBar.add(buttonBorrar);
        toolBar.add(jSeparator2);

        buttonGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/guardar.png"))); // NOI18N
        buttonGuardar.setText("Guardar");
        buttonGuardar.setEnabled(false);
        buttonGuardar.setFocusable(false);
        buttonGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonGuardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGuardarActionPerformed(evt);
            }
        });
        toolBar.add(buttonGuardar);

        buttonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/error.png"))); // NOI18N
        buttonCancelar.setText("Cancelar");
        buttonCancelar.setEnabled(false);
        buttonCancelar.setFocusable(false);
        buttonCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonCancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelarActionPerformed(evt);
            }
        });
        toolBar.add(buttonCancelar);

        northPanel.add(toolBar);

        cbTableChooser.setModel(comboBoxModel);
        cbTableChooser.setMaximumSize(new java.awt.Dimension(50, 20));
        northPanel.add(cbTableChooser);

        getContentPane().add(northPanel, java.awt.BorderLayout.NORTH);

        centerPanel.setLayout(new java.awt.CardLayout());
        getContentPane().add(centerPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void initCustomComponents() {        
        currentCenterPanel = panelAula;
        
        /*Model to show data into the ComboBox*/
        comboBoxModel = new DefaultComboBoxModel<>();
        comboBoxModel.addElement(panelAula);
        comboBoxModel.addElement(panelDocente);
        comboBoxModel.addElement(panelGrupo);
        comboBoxModel.addElement(panelMateria);
    }
    
    public void addPanelsToCenterPanel() {        
        /*Add elements with to the panel-card*/
        centerPanel.add(panelAula, TableNameConstant.AULAS);
        centerPanel.add(panelDocente, TableNameConstant.DOCENTES);
        centerPanel.add(panelGrupo, TableNameConstant.GRUPOS);
        centerPanel.add(panelMateria, TableNameConstant.MATERIAS);
    }    
    
    public void addListeners() {
        cbTableChooser.addItemListener(this);
        MyListSelectionListener.createListSelectionListener(this);
        panelAula.addListeners();
        panelDocente.addListeners();
        panelGrupo.addListeners();
        panelMateria.addListeners();
    }
    
    private void buttonNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNuevoActionPerformed
        setAllEnabledFalse();
        buttonNuevo.setEnabled(true);
        buttonGuardar.setEnabled(true);
        buttonCancelar.setEnabled(true);
        
        currentCenterPanel.actionNuevo();
    }//GEN-LAST:event_buttonNuevoActionPerformed

    private void buttonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelarActionPerformed
        setAllEnabledFalse();
        buttonNuevo.setEnabled(true);
        currentCenterPanel.actionCancelar();
    }//GEN-LAST:event_buttonCancelarActionPerformed

    private void buttonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGuardarActionPerformed
        currentCenterPanel.actionGuardar();
        buttonCancelarActionPerformed(evt); //Se desactivan los controles como en el boton cancelar
    }//GEN-LAST:event_buttonGuardarActionPerformed

    private void buttonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEditarActionPerformed
        setAllEnabledFalse();
        buttonCancelar.setEnabled(true);
        buttonGuardar.setEnabled(true);    
        
        currentCenterPanel.actionEditar();
    }//GEN-LAST:event_buttonEditarActionPerformed

    private void buttonBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBorrarActionPerformed
        setAllEnabledFalse();
        buttonNuevo.setEnabled(true);
        
        currentCenterPanel.actionBorrar();
    }//GEN-LAST:event_buttonBorrarActionPerformed

    @Override
    public void itemStateChanged(ItemEvent e) {
        currentCenterPanel.clearTableSelection();
        SuperPanel panelSeleccionado = (SuperPanel) e.getItem();
        CardLayout cl = (CardLayout) (centerPanel.getLayout());
        cl.show(centerPanel, panelSeleccionado.toString());
        currentCenterPanel = panelSeleccionado;
        
        setAllEnabledFalse();
        buttonNuevo.setEnabled(true);
    }
    
    public void setAllEnabledFalse() {
        buttonNuevo.setEnabled(false);
        buttonEditar.setEnabled(false);
        buttonBorrar.setEnabled(false);
        buttonGuardar.setEnabled(false);
        buttonCancelar.setEnabled(false);
    }

    public JButton getButtonBorrar() {
        return buttonBorrar;
    }

    public JButton getButtonCancelar() {
        return buttonCancelar;
    }

    public JButton getButtonEditar() {
        return buttonEditar;
    }

    public JButton getButtonGuardar() {
        return buttonGuardar;
    }

    public JButton getButtonNuevo() {
        return buttonNuevo;
    }

    public SuperPanel getCurrentCenterPanel() {
        return currentCenterPanel;
    }
    
    private static void createAndShowGUI() {
        JFrame frame = new ApplicationTables();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    public static void main(String args[]) {
        DaoManager manager = MariaDaoManager.createMariaDaoManager("root", "123");
        TableModelFactory.createTableModelFactory(manager);        
        createAndShowGUI();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonBorrar;
    private javax.swing.JButton buttonCancelar;
    private javax.swing.JButton buttonEditar;
    private javax.swing.JButton buttonGuardar;
    private javax.swing.JButton buttonNuevo;
    private javax.swing.JComboBox<SuperPanel> cbTableChooser;
    private javax.swing.JPanel centerPanel;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JPanel northPanel;
    private javax.swing.JToolBar toolBar;
    // End of variables declaration//GEN-END:variables

}
