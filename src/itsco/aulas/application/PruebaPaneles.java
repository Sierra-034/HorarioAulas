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

    public PruebaPaneles(Container panelContainer) {
        JPanel comboBoxPane = new JPanel();
        String[] bomboBoxItems = {AULAS, DOCENTES, GRUPOS, MATERIAS};
        JComboBox cb = new JComboBox(bomboBoxItems);
        cb.addItemListener(this);
        comboBoxPane.add(cb);
        
        VistaAula panelAula = new VistaAula();
        VistaDocente panelDocente = new VistaDocente();
        VistaGrupo panelGrupo = new VistaGrupo();
        VistaMateria panelMateria = new VistaMateria();
        
        centerPanel = new JPanel(new CardLayout()); 
        centerPanel.add(panelAula, AULAS);
        centerPanel.add(panelDocente, DOCENTES);
        centerPanel.add(panelGrupo, GRUPOS);
        centerPanel.add(panelMateria, MATERIAS);
        
        panelContainer.add(comboBoxPane, BorderLayout.NORTH);
        panelContainer.add(centerPanel, BorderLayout.CENTER);
    }    

    @Override
    public void itemStateChanged(ItemEvent e) {
        CardLayout cl = (CardLayout) (centerPanel.getLayout());
        cl.show(centerPanel, (String) e.getItem());
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
