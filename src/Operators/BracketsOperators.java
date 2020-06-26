/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operators;

/**
 * This class has the parenthesis operators that are necessary to complete
 * and understand the formula that the user enters. 
*/

/**
 *
 * @author Emily Herrera, Alana Atencio, Sofia Guido.
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

    /**
     *This method returns the parentheses on the right side
     * @return right bracket
     */
    public String getBracketRight() {
        return bracketRight;
    }

    /**
     * This method places a parenthesis on the right side
     * @param bracketRight
     */
    public void setBracketRight(String bracketRight) {
        this.bracketRight = bracketRight;
    }

    /**
     *This method returns the parentheses on the left side
     * @return left bracket
     */
    public String getBracketLeaft() {
        return bracketLeaft;
    }

    /**
     *This method places a parenthesis on the left side
     * @param bracketLeaft
     */
    public void setBracketLeaft(String bracketLeaft) {
        this.bracketLeaft = bracketLeaft;
    }

    /**
     * This method returns the priority
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
