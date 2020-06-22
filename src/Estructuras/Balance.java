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

    private Cola colaFormulaOriginal = new Cola();

    public void split(String formula) throws ColaException, BalanceException {
        if (esBalanceada(formula) == true) {
            formula = specialOpe(formula);
            if (validLetters(formula)) {
                for (char letra : formula.toCharArray()) {
                    colaFormulaOriginal.enqueue(String.valueOf(letra));

                }
            }
        }

    }

    public boolean validLetters(String formula) throws BalanceException {
        for (int i = 0; i < formula.length(); i++) {
            if (Character.isLetterOrDigit(formula.charAt(i)) == true) {
                if (i != formula.length() - 1) {
                    if (Character.isLetterOrDigit(formula.charAt(i + 1)) == true) {
                        throw new BalanceException("La formula ingresada no se encuentra correctamente balanceada");
                    }
                }else {
                    return true;
                }
            }
        }
        return true;
    }

    private String specialOpe(String formula) {
        for (int i = 0; i < SpecialOperators.values().length; i++) {
            String operator = SpecialOperators.values()[i].getDescription();
            boolean contains = formula.contains(operator);
            if (contains == true) {
                formula = formula.replaceAll(operator, SpecialOperators.values()[i].getSimbol());
            }
        }
        return formula;
    }
    
public boolean esBalanceada(String formula) {

        Pila pila = new Pila();

        for (char letra : formula.toCharArray()) {
            try {
                if (letra == '(' || letra == '[' || letra == '{') {
                    pila.push(letra);
                } else {
                    switch (letra) {
                        case ')':
                            if (pila.pop() != '(') {
                                return false;
                            }
                            break;
                        case ']':
                            if (pila.pop() != '[') {
                                return false;
                            }
                            break;
                        case '}':
                            if(pila.pop() != '{'){
                                return false;
                            }
                            break;
                    }

                }
            } catch (PilaException e) {
                return false;
            }
        }
        if(pila.size() != 0){
            return false;
        }
        return true;
    }
}
