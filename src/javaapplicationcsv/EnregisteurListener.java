/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplicationcsv;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import javaapplicationcsv.GestionFichiers;
/**
 *
 * @author chris
 */
public class EnregisteurListener implements ActionListener{
   private JTable table;
    private String path;

    public EnregisteurListener(String path, JTable table) {
        this.table = table;
        this.path=path;
    }

    public void actionPerformed(ActionEvent arg0) {
        try{
            List<String> lignes = new ArrayList<String>();
            StringBuilder sb0 = new StringBuilder();
            for(int i=0; i<table.getTableHeader().getColumnModel().getColumnCount()-1; i++){
                sb0.append(table.getTableHeader().getColumnModel().getColumn(i).getHeaderValue()).append(";");
            }
            sb0.append(table.getTableHeader().getColumnModel().getColumn(table.getTableHeader().getColumnModel().getColumnCount()-1).getHeaderValue());
            lignes.add(sb0.toString());
            for(int i=0; i<table.getRowCount(); i++){
                StringBuilder sb = new StringBuilder();
                for(int j=0; j<table.getColumnCount()-1; j++){
                    sb.append(table.getValueAt(i, j)).append(";");
                }
                sb.append(table.getValueAt(i, table.getColumnCount()-1));
                lignes.add(sb.toString());
            }
            GestionFichiers.getInstance().ecrireFichier(path, lignes);
            JOptionPane.showMessageDialog(null, "Modifications enregistrées", "Enregistrement", JOptionPane.INFORMATION_MESSAGE);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "L'enregistrement a échoué", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    } 
}
