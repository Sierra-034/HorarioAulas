/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itsco.aulas.vista;

import javax.swing.JPanel;

/**
 *
 * @author Samuel Gomez
 */
public class SuperPanel extends JPanel {
    
    protected String tableName;

    public SuperPanel() {}

    public SuperPanel(String tableName) {
        this.tableName = tableName;
    }

    @Override
    public String toString() {
        return tableName;
    }
}
