/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operators;

/**
 * This class contains the operators of operations, 
 * in addition it is in charge of assigning the priority of these. 
 */

/**
 *
 * @author Emily Herrera, Alana Atencio, Sofia Guido
 */
public enum OrdinalOperators {

    
    POWER("^", 1),

    
    MULTIPLICATION("*", 2),

    
    DIVISION("/", 2),

    
    SUM("+", 3),

    
    RES("-", 3);
    
    private String symbol;
    private int priority;

    private OrdinalOperators(String symbol, int priority) {
        this.symbol = symbol;
        this.priority = priority;
    }

    /**
     * This method returns the symbol
     * @return symbol
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * This method places the symbol
     * @param symbol
     */
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    /**
     *This method returns the priority
     * @return priority
     */
    public int getPriority() {
        return priority;
    }

    /**
     * This method places the priority
     * @param priority
     */
    public void setPriority(int priority) {
        this.priority = priority;
    }
    
    
   
    
            
}
