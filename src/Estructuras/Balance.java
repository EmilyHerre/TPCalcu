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
    private Cola ColaFormulaPostfija = new Cola();
    private Pila operators = new Pila();

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
                } else {
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
                formula = formula.replace(operator, SpecialOperators.values()[i].getSimbol());
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
                            if (pila.pop() != '{') {
                                return false;
                            }
                            break;
                    }

                }
            } catch (PilaException e) {
                return false;
            }
        }
        if (pila.size() != 0) {
            return false;
        }
        return true;
    }

    private boolean isDigitOrLetter(char digit) {
        return Character.isLetterOrDigit(digit) == true;
    }

    public int findPriority(String data) {
        for (int i = 0; i < OrdinalOperators.values().length; i++) {
            if (OrdinalOperators.values()[i].getSymbol().equals(data)) {
                return OrdinalOperators.values()[i].getPriority();
            }
        }

        for (int i = 0; i < SpecialOperators.values().length; i++) {
            if (SpecialOperators.values()[i].getSimbol().equals(data)) {
                return SpecialOperators.values()[i].getPRIORITY();
            }
        }

        for (int i = 0; i < BracketsOperators.values().length; i++) {
            if (BracketsOperators.values()[i].getBracketLeaft().equals(data) || BracketsOperators.values()[i].getBracketRight().equals(data)) {
                return BracketsOperators.values()[i].getPriority();
            }
        }
        return -1;

    }
  

    private void orderPriority(String data1, char data2) throws PilaException, ColaException {
        if (findPriority(data1) < findPriority(String.valueOf(data2))) {
            operators.push(data1.charAt(0));
        }else {
           if (data1.equals(")") || data1.equals("}") || data1.equals("]")){
               while(true) {
                 if(operators.top() != '('){
                 ColaFormulaPostfija.enqueue(String.valueOf(operators.pop()));
                 }else {
                     operators.pop();
                     break;
                 }
               }
           } else {
               while(!operators.empty()) {
                   ColaFormulaPostfija.enqueue(String.valueOf(operators.pop()));
               }
               operators.push(data1.charAt(0));
           }
           
        }

    }

    public void formulaPosfija() throws ColaException, PilaException {
        while(!colaFormulaOriginal.isEmpty()) {
        String data = colaFormulaOriginal.dequeue();
        if (isDigitOrLetter(data.charAt(0))) {
            ColaFormulaPostfija.enqueue(data);
        } else {
            if(operators.empty()){
            operators.push(data.charAt(0));
            
            }else {
                 orderPriority(data, operators.top());
            }
        }
        }
        
        while(!operators.empty()){
             ColaFormulaPostfija.enqueue(String.valueOf(operators.pop())); 
    }
    }

}
