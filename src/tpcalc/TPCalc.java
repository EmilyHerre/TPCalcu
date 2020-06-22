/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpcalc;

import Estructuras.Balance;
import Estructuras.BalanceException;
import Estructuras.ColaException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Emily
 */
public class TPCalc {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        try {
            // TODO code application logic here
            Balance balance = new Balance();
        try {
            balance.split("(A+B * cos-4)");
            // System.out.println("balance " + balance.esBalanceada("(A+B)"));

        } catch (ColaException ex) {
            Logger.getLogger(TPCalc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BalanceException ex) {
            Logger.getLogger(TPCalc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
