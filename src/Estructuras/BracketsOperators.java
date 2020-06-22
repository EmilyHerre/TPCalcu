/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

/**
 *
 * @author Emily
 */
public enum BracketsOperators {
    
    BRACKETSQUARE("[", "]", 4),
    BRACKETCIRCLE("(", ")", 4),
    BRACKETKEYS("{", "}", 4);
    
    private String bracketRight, bracketLeaft;
    private int priority;

    private BracketsOperators(String bracketRight, String bracketLeaft, int priority) {
        this.bracketRight = bracketRight;
        this.bracketLeaft = bracketLeaft;
        this.priority = priority;
    }

    public String getBracketRight() {
        return bracketRight;
    }

    public void setBracketRight(String bracketRight) {
        this.bracketRight = bracketRight;
    }

    public String getBracketLeaft() {
        return bracketLeaft;
    }

    public void setBracketLeaft(String bracketLeaft) {
        this.bracketLeaft = bracketLeaft;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
    
    
}
