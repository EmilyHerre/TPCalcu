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
 * The LogicCalculate class is responsible for the mechanics of mathematical
 * operations
 *
 * @author Emily Herrera, Alana Atencio, Vanessa Guido
 */
public class LogicCalculate {

    //Attributes
    private ColaFormulaPostfija queuePostfixFormula; //reference to where the balanced formula is stored
    private PilaNumbers results = new PilaNumbers(); ////reference to where the results is stored

    //Builder
    public LogicCalculate(ColaFormulaPostfija queuePostfixFormula) {
        this.queuePostfixFormula = queuePostfixFormula;
    }

    /**
     * The private method operations Specials is in charge of verifying if the
     * entered operator belongs to some of the cases and if it does so with the
     * entered element it performs its operation
     *
     * @param digit
     * @param operator
     * @return
     */
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

    /**
     * The private factorial method performs the mathematical operation that
     * with the number entered, the result of its factorial breaks down
     *
     * @param num
     * @return
     */
    private int factorial(double num) {
        if (num == 0) {
            return 1;
        } else {
            return (int) ((double) num * factorial(num - 1));
        }
    }

    /**
     * The private method operations Specials is in charge of verifying if the
     * entered operator belongs to some of the cases and if it does so with the
     * entered element it performs its operation
     *
     * @param num1
     * @param num2
     * @param operator
     * @return
     */
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

    /**
     * The calculate method is responsible for calculating the results of each
     * operation of the formula and returning the final result
     *
     * @return
     * @throws ColaException
     * @throws PilaException
     */
    public double calculate() throws ColaException, PilaException {
        while (!queuePostfixFormula.isEmpty()) {
            String data = queuePostfixFormula.dequeue();
            if (Character.isLetterOrDigit(data.charAt(0)) == true) {
                results.push(Double.parseDouble(data)); //the numeric digits of the formula are stored in the 
                //result stack waiting to be processed
            } else { //Special operators
                for (int i = 0; i < SpecialOperators.values().length; i++) {
                    if (SpecialOperators.values()[i].getSimbol().equals(data)) {
                        double result1 = operationsSpecials(results.pop(), String.valueOf(data));
                        results.push(result1);

                    } //verify to which numbering the operator belongs and according to which operational method to perform
                }
                //ordinal operators
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
        return results.pop(); //returns the final result located on the stack

    }
}
