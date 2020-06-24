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
 *
 * @author Alana
 */
public class SustitutionLetters {

    private ColaFormulaPostfija formulaPostfija;
    private ArrayList<String> listLetters;

    /**
     *
     * @param formulaPostfija
     */
    public SustitutionLetters(ColaFormulaPostfija formulaPostfija) {
        this.formulaPostfija = formulaPostfija;
        this.listLetters = formulaPostfija.getLetters();
    }

    /**
     *
     * @return
     */
    public String letters() {
        String letters = listLetters.get(0);
        listLetters.remove(letters);
        return letters;
    }
    
    /**
     *
     * @return
     */
    public int cantLetters() {
      return listLetters.size();
    }

    /**
     *
     * @param letters
     * @param value
     * @throws ColaException
     */
    public void gg(String letters, double value) throws ColaException {
        formulaPostfija.replace(letters, value);
    }

    /**
     *
     * @return
     */
    public ColaFormulaPostfija getFormulaPostfija() {
        return formulaPostfija;
    }

}
