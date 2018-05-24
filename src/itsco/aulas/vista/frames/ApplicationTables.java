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
import itsco.aulas.vista.VistaAula;
import itsco.aulas.vista.VistaDocente;
import itsco.aulas.vista.VistaGrupo;
import itsco.aulas.vista.VistaMateria;
import java.awt.CardLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Samuel Gomez
 */
public class ApplicationTables extends javax.swing.JFrame implements ItemListener {
    
    private JPanel currentCenterPanel;
    private final JPanel panelAula;
    private final JPanel panelDocente;
    private final JPanel panelGrupo;
    private final JPanel panelMateria;
    private DefaultComboBoxModel<String> comboBoxModel;

    public ApplicationTables() {
        panelAula = new VistaAula();
        panelDocente = new VistaDocente();
        panelGrupo = new VistaGrupo();
        panelMateria = new VistaMateria();
        
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
        cbTableChooser = new javax.swing.JComboBox<>();
        centerPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        northPanel.setLayout(new java.awt.GridLayout(2, 0));

        toolBar.setRollover(true);

        buttonNuevo.setText("Nuevo");
        buttonNuevo.setFocusable(false);
        buttonNuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonNuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(buttonNuevo);

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
        /*Modelo para mostrar datos en el ComboBox*/
        comboBoxModel = new DefaultComboBoxModel<>();
        comboBoxModel.addElement(TableNameConstant.AULAS);
        comboBoxModel.addElement(TableNameConstant.DOCENTES);
        comboBoxModel.addElement(TableNameConstant.GRUPOS);
        comboBoxModel.addElement(TableNameConstant.MATERIAS);
    }
    
    public void addListeners() {
        cbTableChooser.addItemListener(this);
    }
    
    public void addPanelsToCenterPanel() {        
        /*Añade los elementos al panel con el card*/
        centerPanel.add(panelAula, TableNameConstant.AULAS);
        centerPanel.add(panelDocente, TableNameConstant.DOCENTES);
        centerPanel.add(panelGrupo, TableNameConstant.GRUPOS);
        centerPanel.add(panelMateria, TableNameConstant.MATERIAS);
    }
    
    @Override
    public void itemStateChanged(ItemEvent e) {
        String selectedItem = (String) e.getItem();
        CardLayout cl = (CardLayout) (centerPanel.getLayout());
        cl.show(centerPanel, selectedItem);
        setCurrentPanelByComboBoxItem(selectedItem);
    }
    
    private void setCurrentPanelByComboBoxItem(String selectedItem) {
        switch(selectedItem) {
            case TableNameConstant.AULAS: currentCenterPanel = panelAula;
            case TableNameConstant.DOCENTES: currentCenterPanel = panelDocente;
            case TableNameConstant.GRUPOS: currentCenterPanel = panelGrupo;
            case TableNameConstant.MATERIAS: currentCenterPanel = panelMateria;
        }
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
    private javax.swing.JButton buttonNuevo;
    private javax.swing.JComboBox<String> cbTableChooser;
    private javax.swing.JPanel centerPanel;
    private javax.swing.JPanel northPanel;
    private javax.swing.JToolBar toolBar;
    // End of variables declaration//GEN-END:variables

}
