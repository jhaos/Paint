/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

/**
 *
 * @author julius
 */
public class listaColores extends JLabel implements ListCellRenderer<Color>{
    private JButton boton = new JButton();
    
    public listaColores(){
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(50, 25));
        
        boton.setText("");
        boton.setPreferredSize(new Dimension(50,25));
        add(boton, BorderLayout.WEST);
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends Color> list, Color value, int index, boolean isSelected, boolean cellHasFocus) {
        boton.setBackground(value);
        return this;
    }
}
