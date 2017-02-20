/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import attheraces.SQLOperador;
import javax.swing.JComboBox;

/**
 *
 * @author Marcelo
 */
public class ComboBoxFiltroWhereSQL extends JComboBox {

    public ComboBoxFiltroWhereSQL() {
        atualizaCombo();
    }
    
    public void atualizaCombo() {
        removeAllItems();
        for(SQLOperador a : SQLOperador.getArray()) {
            addItem(a);
        }
    }
    
    public SQLOperador getWhereSelecionado() {
        if(getSelectedIndex() != -1) {
            return (SQLOperador) getSelectedItem();
        }
        return null;
    }
    
}
