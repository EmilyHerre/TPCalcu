/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operators;

/**
 * This class is in charge of assigning priority,
 * and a symbol to special operators.
 */

/**
 *
 * @author Emily Herrera, Alana Atencio, Sofia Guido.
 */

public enum SpecialOperators {

    
    COS("cos", "#", 1),

    
    SEN("sen", "%", 1),

   
    TAN("tan", "&", 1),

    
    SQRT("sqrt", "$", 1),

    
    FACTO("facto", "@", 1);

    private String description, simbol;
    private final int PRIORITY;

    private SpecialOperators(String description, String simbol, int PRIORITY) {
        this.description = description;
        this.simbol = simbol;
        this.PRIORITY = 1;
    }

/**
     * This method returns the description
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method assigns the description
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * This method returns the symbol
     * @return symbol
     */
    public String getSimbol() {
        return simbol;
    }

    /**
     * This method assigns the symbol
     * @param symbol
     */
    public void setSimbol(String simbol) {
        this.simbol = simbol;
    }

/**
     * This method returns the priority
     * @return priority
     */
    public int getPRIORITY() {
        return PRIORITY;
    }
    
    
    

}
