/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplicationcsv;

/**
 *
 * @author chris
 */
public class FichierException extends Exception{
private static final long serialVersionUID = 1L;

    public FichierException() {
        super();
    }

    public FichierException(String arg0, Throwable arg1) {
        super(arg0, arg1);
    }

    public FichierException(String arg0) {
        super(arg0);
    }

    public FichierException(Throwable arg0) {
        super(arg0);
    }

}
