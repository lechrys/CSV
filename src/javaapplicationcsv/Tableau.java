/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplicationcsv;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author chris
 */
public class Tableau extends JPanel{
    private static final long serialVersionUID = -1572744239267031822L;
    
    private JTable table;

    public Tableau(final Object[] entetes, final boolean editable){
        setLayout(new GridLayout(1, 0));
        Object[][] data = new Object[0][entetes.length];
        DefaultTableModel model = new DefaultTableModel(data, entetes){
            private static final long serialVersionUID = 8142475658077955728L;
            public boolean isCellEditable(int rowIndex, int columnIndex){
                return editable;
            }
        };
        table=new JTable(model);
        table.setOpaque(false);
        add(table);
    }

    public void ajouter(){
        ((DefaultTableModel)(table.getModel())).addRow(new String[table.getColumnCount()]);
    }
    
    public void supprimer(){
        ((DefaultTableModel)(table.getModel())).removeRow(table.getSelectedRow());
    }
    
    public void ajouterLigne(Object[] donnees){
        ((DefaultTableModel)(table.getModel())).addRow(donnees);
    }

    public JTable getTable() {
        return table;
    }
}
