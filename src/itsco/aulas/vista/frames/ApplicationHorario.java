/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itsco.aulas.vista.frames;

import itsco.aulas.dao.DaoAula;
import itsco.aulas.dao.DaoManager;
import itsco.aulas.dao.mariadb.MariaDaoManager;
import itsco.aulas.modelo.tablas.TableModelFactory;
import itsco.aulas.modelo.tablas.TableModelHorario;
import java.util.ArrayList;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;

/**
 *
 * @author Samuel Gomez
 */
public class ApplicationHorario extends javax.swing.JFrame implements TreeSelectionListener {

    private DaoAula manager = MariaDaoManager.getInstance().createDaoAula();
    private DefaultMutableTreeNode root;
    private TableModelHorario modelHorario;
    
    public ApplicationHorario() {
        initCustomComponents();
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        treeEdificios = new javax.swing.JTree(root);
        jScrollPane2 = new javax.swing.JScrollPane();
        horarioGeneral = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jSplitPane1.setDividerLocation(200);
        jSplitPane1.setDividerSize(5);
        jSplitPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jSplitPane1.setMinimumSize(new java.awt.Dimension(118, 26));
        jSplitPane1.setPreferredSize(new java.awt.Dimension(600, 500));
        jSplitPane1.setDividerLocation(200);

        treeEdificios.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        treeEdificios.addTreeSelectionListener(this);
        jScrollPane1.setViewportView(treeEdificios);

        jSplitPane1.setLeftComponent(jScrollPane1);

        jScrollPane2.setAutoscrolls(true);

        horarioGeneral.setModel(modelHorario);
        horarioGeneral.setPreferredSize(new java.awt.Dimension(150, 64));
        jScrollPane2.setViewportView(horarioGeneral);

        jSplitPane1.setRightComponent(jScrollPane2);

        getContentPane().add(jSplitPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        DaoManager manager = MariaDaoManager.createMariaDaoManager("root", "123");
        TableModelFactory.createTableModelFactory(manager);
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ApplicationHorario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ApplicationHorario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ApplicationHorario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ApplicationHorario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ApplicationHorario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable horarioGeneral;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTree treeEdificios;
    // End of variables declaration//GEN-END:variables

    private void initCustomComponents() {
        modelHorario = TableModelFactory.getInstance().getTableModelHorario();
        modelHorario.loadData();
        createTreeNodes();
    }

    private void createTreeNodes() {
        root = new DefaultMutableTreeNode("Edificios");
        DefaultMutableTreeNode edificio = new DefaultMutableTreeNode();
        ArrayList<String> nombreEdificios = manager.selectEdificios();
        
        for(String nombreEdificio : nombreEdificios) {
            edificio = new DefaultMutableTreeNode(nombreEdificio);
            createLiefNodes(edificio, nombreEdificio);
            root.add(edificio);
        }
    }

    private void createLiefNodes(DefaultMutableTreeNode edificio, String nombreEdificio) {
        ArrayList<String> nombreAulas = manager.aulaByEdificio(nombreEdificio);
        DefaultMutableTreeNode aula = new DefaultMutableTreeNode();
        
        for(String nombreAula : nombreAulas) {
            aula = new DefaultMutableTreeNode(nombreAula);
            edificio.add(aula);
        }
    }

    @Override
    public void valueChanged(TreeSelectionEvent e) {
        DefaultMutableTreeNode selectedNode = 
                (DefaultMutableTreeNode) treeEdificios.getLastSelectedPathComponent();
        
        //No se seleccionó nada
        if(selectedNode == null)
            return;
        
        if(selectedNode.isLeaf()) {
            String idAula = selectedNode.getUserObject().toString();
            modelHorario.loadDataByAula(idAula);
            modelHorario.fireTableDataChanged();
        }
    }
}
