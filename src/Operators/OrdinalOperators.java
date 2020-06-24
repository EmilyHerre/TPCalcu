/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operators;

/**
 *
 * @author Emily
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

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
    
    
   
    
            
}
