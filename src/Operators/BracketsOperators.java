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
public enum BracketsOperators {
    
    /**
     *
     */
    BRACKETSQUARE("[", "]", 4),

    /**
     *
     */
    BRACKETCIRCLE("(", ")", 4),

    /**
     *
     */
    BRACKETKEYS("{", "}", 4);
    
    private String bracketRight, bracketLeaft;
    private int priority;

    private BracketsOperators(String bracketRight, String bracketLeaft, int priority) {
        this.bracketRight = bracketRight;
        this.bracketLeaft = bracketLeaft;
        this.priority = priority;
    }

    /**
     *
     * @return
     */
    public String getBracketRight() {
        return bracketRight;
    }

    /**
     *
     * @param bracketRight
     */
    public void setBracketRight(String bracketRight) {
        this.bracketRight = bracketRight;
    }

    /**
     *
     * @return
     */
    public String getBracketLeaft() {
        return bracketLeaft;
    }

    /**
     *
     * @param bracketLeaft
     */
    public void setBracketLeaft(String bracketLeaft) {
        this.bracketLeaft = bracketLeaft;
    }

    /**
     *
     * @return
     */
    public int getPriority() {
        return priority;
    }

    /**
     *
     * @param priority
     */
    public void setPriority(int priority) {
        this.priority = priority;
    }
    
    
}
