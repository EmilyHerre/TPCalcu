/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import Exceptions.ColaException;
import List.ColaFormulaPostfija;
import java.util.ArrayList;

/**
 * The SustitutionLetters class is in charge of the mechanics of giving value to
 * the letter type variables in the formula and of the change in the formula of
 * their value
 *
 * @author Alana Atencio, Emily Herrera, Sofia Guido
 */
public class SustitutionLetters {

    private ColaFormulaPostfija postfixFormula; //reference to where the balanced formula is stored
    private ArrayList<String> listLetters; //formula letter list

    //builder
    public SustitutionLetters(ColaFormulaPostfija postfixFormula) {
        this.postfixFormula = postfixFormula;
        this.listLetters = postfixFormula.getLetters();
    }

    /**
     * The letters method is responsible for returning the list letter and
     * eliminates this
     *
     * @return
     */
    public String letters() {
        String letters = listLetters.get(0);
        listLetters.remove(letters);
        return letters;
    }

    /**
     * CountLetters method returns the number of letters
     *
     * @return int count letters
     */
    public int countLetters() {
        return listLetters.size();
    }

    /**
     * The grantValues method gives value to the letter variable and replaces it
     * in the formula
     *
     * @param letters
     * @param value
     * @throws ColaException
     */
    public void grantValues(String letters, double value) throws ColaException {
        postfixFormula.replace(letters, value);
    }

    /**
     * The ColaFormulaPostfija method is responsible for returning the queue
     * with the postfix formula with the replacement of variables
     *
     * @return postfixFormula
     */
    public ColaFormulaPostfija getFormulaPostfija() {
        return postfixFormula;
    }

}
