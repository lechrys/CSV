/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplicationcsv;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javaapplicationcsv.FichierException;
/**
 *
 * @author chris
 */
public class GestionFichiers {
      /**
     * L'unique instance du singleton
     */
    private static final GestionFichiers instance = new GestionFichiers();

    /**
     * Methode d'acces à l'instance  de GestionFichiers
     * @return l'instance de GestionFichiers
     */
    public static final GestionFichiers getInstance(){
        return instance;
    }

    /**
     * Constructeur prive du singleton
     */
    private GestionFichiers(){
        super();
    }

    /**
     * fonction qui lit le contenu d'un fichier
     * @param nomFichier 
     *     nom du fichier en entree
     * @return la liste des lignes
     */
    public List<String> lireFichier(String nomFichier) throws FichierException{
        BufferedReader fluxEntree=null;
        String ligneLue;
        List<String> lignes = new ArrayList<String>();
        try{
            fluxEntree = new BufferedReader(new FileReader(nomFichier));
            ligneLue = fluxEntree.readLine();
            while(ligneLue!=null){
                lignes.add(ligneLue);
                ligneLue = fluxEntree.readLine();
            }
        }
        catch(IOException exc){
            throw new FichierException("Impossible de lire le fichier "+nomFichier, exc);
        }
        try{
            fluxEntree.close();
        }
        catch(IOException e){
            throw new FichierException("Impossible de lire le fichier "+nomFichier, e);
        }
        return lignes;
    }

    /**
     * Cette procédure écrit dans le fichier les lignes de la liste
     * @param nomFichier 
     *     nom du fichier dans lequel écrire
     * @param lignes 
     *     liste des lignes à écrire
     */
    public void ecrireFichier(String nomFichier, List<String> lignes) throws FichierException {
        PrintWriter out=null;
        try{
            out = new PrintWriter(new BufferedWriter(new FileWriter(nomFichier)));
            for(String s : lignes){
                out.println(s);
            }
        }
        catch(IOException exc){
            throw new FichierException("Impossible d'écrire dans le fichier "+nomFichier, exc);
        }
        out.close();
    }
}
