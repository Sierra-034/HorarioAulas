/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itsco.aulas.application;

import itsco.aulas.dao.DaoManager;
import itsco.aulas.dao.mariadb.MariaDaoManager;
import itsco.aulas.modelo.tablas.TableModelFactory;
import itsco.aulas.vista.VistaAula;
import itsco.aulas.vista.VistaDocente;
import itsco.aulas.vista.VistaGrupo;
import itsco.aulas.vista.VistaMateria;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Samuel Gomez
 */
public class PruebaPaneles implements ItemListener {
    
    private JPanel centerPanel;
    private final static String AULAS = "Aulas";
    private final static String DOCENTES = "Docentes";
    private final static String GRUPOS = "Grupos";
    private final static String MATERIAS = "Materias";
    
//    private final JPanel panelAula;
    private final JPanel panelDocente;
    private final JPanel panelGrupo;
    private final JPanel panelMateria;
    private JPanel currentPanel;

    public PruebaPaneles(Container panelContainer) {
        JPanel northPane = new JPanel();
        
        /*Crea el ComboBox que controlará el CardLayout*/
        String[] bomboBoxItems = {AULAS, DOCENTES, GRUPOS, MATERIAS};
        JComboBox cb = new JComboBox(bomboBoxItems);
        cb.addItemListener(this);
        northPane.add(cb);
        
//        panelAula = new VistaAula();
        panelDocente = new VistaDocente();
        panelGrupo = new VistaGrupo();
        panelMateria = new VistaMateria();
//        currentPanel = panelAula;
        
        centerPanel = new JPanel(new CardLayout()); 
//        centerPanel.add(panelAula, AULAS);
        centerPanel.add(panelDocente, DOCENTES);
        centerPanel.add(panelGrupo, GRUPOS);
        centerPanel.add(panelMateria, MATERIAS);
        
        panelContainer.add(northPane, BorderLayout.NORTH);
        panelContainer.add(centerPanel, BorderLayout.CENTER);
    }    

    @Override
    public void itemStateChanged(ItemEvent e) {
        String selectedItem = (String) e.getItem();
        CardLayout cl = (CardLayout) (centerPanel.getLayout());
        cl.show(centerPanel, selectedItem);
        setCurrentPanelByComboBoxItem(selectedItem);
    }
    
    public void setCurrentPanelByComboBoxItem(String panelName) {
        switch(panelName) {
//            case AULAS: currentPanel = panelAula;
            case DOCENTES: currentPanel = panelDocente;
            case GRUPOS: currentPanel = panelGrupo;
            case MATERIAS: currentPanel = panelMateria;
            
//            default: currentPanel = panelAula;
        }
    }

    public static void createAndShowGUI() {
        JFrame frame = new JFrame("Horario Aulas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        PruebaPaneles paneles = new PruebaPaneles(frame.getContentPane());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        DaoManager manager = MariaDaoManager.createMariaDaoManager("root", "123");
        TableModelFactory.createTableModelFactory(manager);
        createAndShowGUI();
    }
    
}
