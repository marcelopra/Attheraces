/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author marcelo
 */
public class TablePadraoButtonColumn extends AbstractCellEditor implements TableCellRenderer, TableCellEditor, ActionListener {  
     private JTable table;  
     private JButton renderButton;  
     private JButton editButton;  
     private String text;  

     public TablePadraoButtonColumn(JTable table, int column, JButton botao) {  
         super();  
         this.table = table;
         renderButton = botao;  

         editButton = botao;  
         editButton.setFocusPainted( false );  
         editButton.addActionListener( this );  

         TableColumnModel columnModel = table.getColumnModel();  
         columnModel.getColumn(column).setCellRenderer( this );  
         columnModel.getColumn(column).setCellEditor( this );  
     }  

     public Component getTableCellRendererComponent(  
         JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {  
         if (hasFocus) {  
             renderButton.setForeground(table.getForeground());  
             renderButton.setBackground(UIManager.getColor("Button.background"));  
         } else if (isSelected) {
             renderButton.setForeground(table.getSelectionForeground());
             renderButton.setBackground(table.getSelectionBackground());
         } else {  
             renderButton.setForeground(table.getForeground());  
             renderButton.setBackground(UIManager.getColor("Button.background"));  
         }
         return renderButton;  
     }  

     public Component getTableCellEditorComponent(  
         JTable table, Object value, boolean isSelected, int row, int column) {
         return editButton;  
     }  

     public Object getCellEditorValue() {  
         return text;  
     }  

     public void actionPerformed(ActionEvent e) {  
         fireEditingStopped();
     }
}  
