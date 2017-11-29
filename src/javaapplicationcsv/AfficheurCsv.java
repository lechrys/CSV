/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplicationcsv;
import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import javaapplicationcsv.FichierException;
import javaapplicationcsv.GestionFichiers;
import javaapplicationcsv.ParseurCsv;
/**
 *
 * @author chris
 */
public class AfficheurCsv extends JPanel {
     private static final long serialVersionUID = 7354456748439411793L;
    
    private Tableau table;
    private JButton enregistrer;

    public AfficheurCsv(String path){
        try {
            setLayout(new BorderLayout());
            List<String> lignes;
            lignes = GestionFichiers.getInstance().lireFichier(path);
            List<Object[]> rows = ParseurCsv.getInstance().parserCsv(lignes);
            Object[] entetes = rows.remove(0);
            table = new Tableau(entetes, true);
            for(Object[] s : rows){
                table.ajouterLigne(s);
            }
            add(table.getTable().getTableHeader(), BorderLayout.NORTH);
            add(new JScrollPane(table), BorderLayout.CENTER);
            enregistrer = new JButton("Enregistrer les modifications");
            enregistrer.addActionListener(new EnregisteurListener(path, table.getTable()));
            add(enregistrer, BorderLayout.SOUTH);
            
        } 
        catch (FichierException e) {
            e.printStackTrace();
        }
    }
}
