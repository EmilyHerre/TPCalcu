/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exceptions;

import javax.swing.JOptionPane;


/**
 *  This class handles the exceptions presented in a stack
 * @author Emily Herrera, Alana Atencio, Sofia Guido
 */
public class PilaException extends Exception{

    /**
     *
     * @param message
     */
    public PilaException(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    
    
}

