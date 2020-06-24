/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exceptions;

/**
 *  This class handles the exceptions presented in a queue
 * @author Emily Herrera, Alana Atencio, Sofia Guido
 */
public class ColaException extends Exception{
    
    /**
     *
     * @param msg
     */
    public ColaException(String msg) {
        super(msg);
    }
}
