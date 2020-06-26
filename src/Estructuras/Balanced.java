/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import Exceptions.PilaException;
import Exceptions.ColaException;
import Exceptions.BalanceException;
import List.ColaFormulaPostfija;
import List.ColaFormulaOriginal;
import List.Pila;
import Operators.BracketsOperators;
import Operators.OrdinalOperators;
import Operators.SpecialOperators;

/**
 * The Balancing class is responsible for managing the mechanics of balancing
 * the mathematical formula using a series of methods, with specific
 * requirements
 *
 * @author Emily Herrera, Alana Atencio, Sofia Guido
 */
public class Balanced {

    //Attributes
    private final ColaFormulaOriginal QUEUE_ORIGINAL_FORMULA = new ColaFormulaOriginal(); //reference to where the original formula is stored
    private final ColaFormulaPostfija QUEUE_POSTFIX_FORMULA = new ColaFormulaPostfija();//reference to where the balanced formula is stored
    private final Pila OPERATORS = new Pila();//reference to where the mathematical operators are stored

    /**
     * The getColaFormulaPostfija method is responsible for returning the queue
     * that stores the postfix formula
     *
     * @return QUEUE_POSTFIX_FORMULA
     */
    public ColaFormulaPostfija getColaFormulaPostfija() {
        return QUEUE_POSTFIX_FORMULA;
    }

    /**
     * The checkFormulaBalancing method is responsible for verifying that the
     * formula is in the right conditions for balancing and breaks it down into
     * each letter to pass it to the original formula queue
     *
     * @param formula
     * @throws ColaException
     * @throws BalanceException
     */
    public void checkFormulaBalancing(String formula) throws ColaException, BalanceException {
        if (formula != null && !formula.isEmpty()) { //validates that the formula is not empty or null
            if (isBalanced(formula) == true) {//with the Balancing method verify that the parentheses are correct
                formula = specialOperator(formula); //If the formula contains special elements, this substitutes them with a specific symbol.
                if (validLetters(formula)) { //Validate the positions of the letters or digits that are correct
                    for (char letters : formula.toCharArray()) {
                        if (letters != ' ') { //Check that there are no spaces otherwise throw an exception
                            QUEUE_ORIGINAL_FORMULA.enqueue(String.valueOf(letters)); //passes the elements of the formula to the original list
                        } else {
                            throw new BalanceException("La formula no debe tener espacios en blanco");
                        }
                    }
                }
            }
        } else {
            throw new BalanceException("La formula no debe ser null");
        }

    }

    /**
     * The private method validLetters validates that in the middle of each
     * digit or letter there is a mathematical operator
     *
     * @param formula
     * @return
     * @throws BalanceException
     */
    private boolean validLetters(String formula) throws BalanceException {
        for (int i = 0; i < formula.length(); i++) {
            if (Character.isLetterOrDigit(formula.charAt(i)) == true) {
                if (i != formula.length() - 1) {//When i reaches the end it validates that it is not fixed to a next position
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

    /**
     * The private method specialOperator searches if the formula contains a
     * special mathematical operator contained in the SpecialOperators
     * enumeration then exchanges it for its defined symbol
     *
     * @param formula
     * @return
     */
    private String specialOperator(String formula) {
        for (int i = 0; i < SpecialOperators.values().length; i++) {
            String operator = SpecialOperators.values()[i].getDescription(); //pull out each operator
            boolean contains = formula.contains(operator); //look for the operator in the formula
            if (contains == true) { //Replace the operator with its symbol if it contains it
                formula = formula.replace(operator, SpecialOperators.values()[i].getSimbol());
            }
        }
        return formula;
    }

    /**
     * The private method isBalance is in charge of verifying that the use of
     * parentheses, braces and square brackets is correct.
     *
     * @param formula
     * @return true if it is correct or false if it is not
     */
    private boolean isBalanced(String formula) {
        Pila pila = new Pila(); //it will store the parentheses, brackets or open braces

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

    /**
     * The private method isDigitOrLetter verifies if the char entered is a
     * letter or a digit
     *
     * @param digit
     * @return true
     */
    private boolean isDigitOrLetter(char digit) {
        return Character.isLetterOrDigit(digit) == true;
    }

    /**
     * The private method findPriority searches for the priority of the
     * mathematical operator entered in the different enumeration classes
     * classified according to their type of operator.
     *
     * @param data operator
     * @return returns the priority or if it is not found in any class of
     * operators -1
     */
    private int findPriority(String data) {
        for (int i = 0; i < OrdinalOperators.values().length; i++) { //goes through the list of ordinary operators
            if (OrdinalOperators.values()[i].getSymbol().equals(data)) {
                return OrdinalOperators.values()[i].getPriority();
            }
        }

        for (int i = 0; i < SpecialOperators.values().length; i++) {  //goes through the list of spacial operators
            if (SpecialOperators.values()[i].getSimbol().equals(data)) {
                return SpecialOperators.values()[i].getPRIORITY();
            }
        }

        for (int i = 0; i < BracketsOperators.values().length; i++) {  //goes through the list of brackets 
            if (BracketsOperators.values()[i].getBracketLeaft().equals(data) || BracketsOperators.values()[i].getBracketRight().equals(data)) {
                return BracketsOperators.values()[i].getPriority();
            }
        }
        return -1;

    }

    /**
     * The private method orderPriority receives two operators, one in the
     * operator stack and another one extracted from the original queue,
     * compares them and follows a series of validations according to their
     * priority, if higher than the one in the stack it enters once, if it is
     * less, it passes all the elements to the postfix queue and if it is a
     * parenthesis, bracket or key wait for its inverse
     *
     * @param data1 original formula
     * @param data2 stack operator
     * @throws PilaException
     * @throws ColaException
     */
    private void orderPriority(String data1, char data2) throws PilaException, ColaException {
        if (findPriority(data1) < findPriority(String.valueOf(data2))) {
            OPERATORS.push(data1.charAt(0)); //check if data 1 has a higher priority and enter it in the stack
        } else {
            if (data1.equals(")") || data1.equals("}") || data1.equals("]")) {
                while (true) { //if the data is a key element, parenthesis or closed bracket it passes all the elements above
                    //its inverse pair to the postfix formula queue until finding its pair and then both are eliminated
                    if (OPERATORS.top() != '(' && OPERATORS.top() != '{' && OPERATORS.top() != '[') {
                        QUEUE_POSTFIX_FORMULA.enqueue(String.valueOf(OPERATORS.pop()));
                    } else {
                        OPERATORS.pop();
                        break;
                    }
                }
            } else if (data1.equals("(") || data1.equals("{") || data1.equals("[")) {
                OPERATORS.push(data1.charAt(0)); //if the data is an open parenthesis, key or bracket, the operator stack is entered at once

            } else {
                while (!OPERATORS.empty()) { //if the data is an element with a lower priority and does not correspond to the other cases, the elements of the stack
                    //are passed to the postfix queue as long as it is not an open parenthesis, key or bracket operator
                    if (OPERATORS.top() != '(' && OPERATORS.top() != '{' && OPERATORS.top() != '[') {
                        QUEUE_POSTFIX_FORMULA.enqueue(String.valueOf(OPERATORS.pop()));
                    } else {
                        break;
                    }
                }
                OPERATORS.push(data1.charAt(0)); //when finished enter the data into the stack
            }

        }

    }

    /**
     * The createPostfixFormula method is in charge of correctly recreating the
     * postfix formula, validating the priority of the operators and removing
     * the formula from the original queue to the already postfix
     *
     * @throws ColaException
     * @throws PilaException
     */
    public void createPostfixFormula() throws ColaException, PilaException {
        while (!QUEUE_ORIGINAL_FORMULA.isEmpty()) {
            String data = QUEUE_ORIGINAL_FORMULA.dequeue();
            if (isDigitOrLetter(data.charAt(0))) { //if it is a letter or a digit, enter the postfix queue at once
                QUEUE_POSTFIX_FORMULA.enqueue(data);
            } else {
                if (OPERATORS.empty()) { //if the operator stack is empty, it does not need priority validation and it comes back at once
                    OPERATORS.push(data.charAt(0));

                } else {
                    orderPriority(data, OPERATORS.top()); //sort by operator priority
                }
            }
        }

        while (!OPERATORS.empty()) { //when there are no more elements in the original formula queue,
            // it passes the leftover operators from the stack if they still exist and enters them in the postfix queue
            QUEUE_POSTFIX_FORMULA.enqueue(String.valueOf(OPERATORS.pop()));
        }
    }

}
