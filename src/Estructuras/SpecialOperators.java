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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSimbol() {
        return simbol;
    }

    public void setSimbol(String simbol) {
        this.simbol = simbol;
    }

    public int getPRIORITY() {
        return PRIORITY;
    }
    
    
    

}
