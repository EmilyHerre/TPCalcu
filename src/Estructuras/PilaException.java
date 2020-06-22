/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import javax.swing.JOptionPane;


/**
 *
 * @author Emily
 */
public class PilaException extends Exception{

    public PilaException(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    
    
}

