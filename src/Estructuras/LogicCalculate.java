/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import Exceptions.PilaException;
import Exceptions.ColaException;
import List.ColaFormulaPostfija;
import List.PilaNumbers;
import Operators.OrdinalOperators;
import Operators.SpecialOperators;

/**
 *
 * @author Alana
 */
public class LogicCalculate {

    private ColaFormulaPostfija formulaPostfija;
    private PilaNumbers results = new PilaNumbers();

    public LogicCalculate(ColaFormulaPostfija formulaPostfija) {
        this.formulaPostfija = formulaPostfija;
    }

    private double operationsSpecials(double digit, String operator) {
        double result = 0;

        switch (operator) {
            case "#":
                result = Math.cos(digit);
                break;

            case "%":
                result = Math.sin(digit);
                break;

            case "&":
                result = Math.tan(digit);
                break;

            case "$":
                result = Math.sqrt(digit);
                break;

            case "@":
                result = factorial(digit);
                break;
            default:
                break;
        }
        return result;
    }

    private int factorial(double num) {
        if (num == 0) {
            return 1;
        } else {
            return (int) ((double) num * factorial(num - 1));
        }
    }

    private double operationsOrdinal(double num1, double num2, String operator) {
        double result = 0;

        switch (operator) {
            case "^":
                result = Math.pow(num1, num2);
                break;

            case "*":
                result = num1 * num2;
                break;

            case "/":
                result = num1 / num2;
                break;

            case "+":
                result = num1 + num2;
                break;

            case "-":
                result = num1 - num2;
                break;
            default:
                break;

        }
        return result;
    }

    public double calculate() throws ColaException, PilaException {
        while (!formulaPostfija.isEmpty()) {
            String data = formulaPostfija.dequeue();
            if (Character.isLetterOrDigit(data.charAt(0)) == true) {
                results.push(Double.parseDouble(data));
            } else {
                for (int i = 0; i < SpecialOperators.values().length; i++) {
                    if (SpecialOperators.values()[i].getSimbol().equals(data)) {
                        double result1 = operationsSpecials(results.pop(), String.valueOf(data));
                        results.push(result1);

                    }
                }

                for (int i = 0; i < OrdinalOperators.values().length; i++) {
                    if (OrdinalOperators.values()[i].getSymbol().equals(data)) {
                        double num1 = results.pop();
                        double num2 = results.pop();
                        double result2 = operationsOrdinal(num2, num1, String.valueOf(data));
                        results.push(result2);
                    }
                }
            }

        }
        return results.pop();
        
    }
}
