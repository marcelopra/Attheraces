/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import attheraces.SQLOperador;
import attheraces.SQLOrderBy;
import javax.swing.JComboBox;

/**
 *
 * @author Marcelo
 */
public class ComboBoxOrderBy extends JComboBox {

    public ComboBoxOrderBy() {
        atualizaCombo();
    }
    
    public void atualizaCombo() {
        removeAllItems();
        for(SQLOrderBy a : SQLOrderBy.getArray()) {
            addItem(a);
        }
    }
    
    public SQLOrderBy getOrderBySelecionado() {
        if(getSelectedIndex() != -1) {
            return (SQLOrderBy) getSelectedItem();
        }
        return null;
    }
    
}
