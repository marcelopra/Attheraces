/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author marcelo
 */
public class MyCellRenderer extends DefaultTableCellRenderer {  
    private Color whiteColor = new Color(254, 254, 254);  
    private Color alternateColor = new Color(225, 225, 225);  
    private Color selectedColor = new Color(61, 128, 223);  

    @Override  
    public Component getTableCellRendererComponent(JTable table,  
            Object value, boolean selected, boolean focused, int row,  
            int column) {  

        super.getTableCellRendererComponent(table, value, selected, focused, row, column);

        /*Aplica efeito zebra*/
        Color bg;  
        if (!selected)  
            bg = (row % 2 == 0 ? alternateColor : whiteColor);  
        else  
            bg = selectedColor;
        
        setBackground(bg);  
        setForeground(selected ? Color.white : Color.black);

        return this;  
    }
}