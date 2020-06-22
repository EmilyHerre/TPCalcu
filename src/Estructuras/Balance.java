/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

/**
 *
 * @author Sofia
 */
public class Balance {
    
    public boolean EsBalanceada(String formula) {
        Pila pila = new Pila();

        for (char letra : formula.toCharArray()) {
            try {
                if (letra == '(' || letra == '[' || letra == '{') {
                    pila.push(String.valueOf(letra));
                } else {
                    switch (letra) {
                        case ')':
                            if (!pila.pop().equals("(")) {
                                return false;
                            }
                            break;
                        case ']':
                            if (!pila.pop().equals("[")) {
                                return false;
                            }
                            break;
                        case '}':
                            if (!pila.pop().equals("{")) {
                                return false;
                            }
                            break;
                    } //finaliza switch
                }
            } catch (PilaException ex) {
                return false;
            }
        } //finaliza for
        if (pila.size() != 0) {
            return false;
        }
        return true;
    }//Termina metodo isBalanced
    
}
