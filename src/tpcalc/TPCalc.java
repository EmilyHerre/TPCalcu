/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpcalc;

import Estructuras.Balance;
import Estructuras.BalanceException;
import Estructuras.ColaException;
import Estructuras.PilaException;
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
        try {
            Balance balance = new Balance();
            balance.split("(A+B)*C-sqrt(4)");
            balance.formulaPosfija();
////        try {
        } catch (ColaException ex) {
            Logger.getLogger(TPCalc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BalanceException ex) {
            Logger.getLogger(TPCalc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PilaException ex) {
            Logger.getLogger(TPCalc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
