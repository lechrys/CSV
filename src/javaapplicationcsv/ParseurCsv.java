/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplicationcsv;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author chris
 */
public class ParseurCsv {
    
     private static final ParseurCsv instance = new ParseurCsv();

    private final String SEPARATEUR =";";

    private ParseurCsv(){
        super();
    }

    public List<Object[]> parserCsv(List<String> lignes){
        List<Object[]> res = new ArrayList<Object[]>();
        for(String s : lignes){
            res.add(s.split(SEPARATEUR));
        }
        return res;
    }

    public static ParseurCsv getInstance() {
        return instance;
    }
}
