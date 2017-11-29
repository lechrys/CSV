/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplicationcsv;

import java.awt.Dimension;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.filechooser.FileFilter;

import javaapplicationcsv.AfficheurCsv;
/**
 *
 * @author chris
 */
public class Lanceur {
     private void creerFenetre(String path){
        JFrame f = new JFrame("Affichage d'un fichier csv");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new AfficheurCsv(path));
        f.setSize(new Dimension(700, 500));
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
    
    private void appliquerLookAndFeel(){
        try{
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        }
        catch(Exception e){}
    }
    
    
    private void choisirFichier(){
        JFileChooser jf = new JFileChooser();
        jf.setFileFilter(new FileFilter() {
            private String getExtension(File f) {
                String ext = null;
                String s = f.getName();
                int i = s.lastIndexOf('.');

                if (i > 0 &&  i < s.length() - 1) {
                    ext = s.substring(i+1).toLowerCase();
                }
                return ext;
            }

            @Override
            public String getDescription() {
                return "Fichiers csv *.csv";
            }

            @Override
            public boolean accept(File f) {
                if (f.isDirectory()) {
                    return true;
                }
                String extension = getExtension(f);
                if (extension != null) {
                    if (extension.equals("csv")){
                        return true;
                    } 
                    else {
                        return false;
                    }
                }
                return false;
            }
        });
        int returnVal = jf.showOpenDialog(null);
        if(returnVal==JFileChooser.APPROVE_OPTION){
            creerFenetre(jf.getSelectedFile().getPath());
        }
    }

    public static void main(String[] args) {
        Lanceur l = new Lanceur();
        l.appliquerLookAndFeel();
        l.choisirFichier();

    }
}
