/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itsco.aulas.vista;

/**
 *
 * @author Samuel Gomez
 */
public class ToolBar extends javax.swing.JPanel {

    public ToolBar() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tooBar = new javax.swing.JToolBar();
        buttonNuevo = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        tooBar.setRollover(true);

        buttonNuevo.setText("Nuevo");
        buttonNuevo.setFocusable(false);
        buttonNuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonNuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tooBar.add(buttonNuevo);

        add(tooBar, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonNuevo;
    private javax.swing.JToolBar tooBar;
    // End of variables declaration//GEN-END:variables
}
