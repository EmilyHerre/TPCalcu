/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exceptions;

/**
 *  This class manage the exceptions presented during the formula balancing process
 * @author Emily Herrera, Alana Atencio, Sofia Guido
 */
public class BalanceException extends Exception{

    /**
     *
     * @param message
     */
    public BalanceException(String message) {
        super(message);
    }
    
}
