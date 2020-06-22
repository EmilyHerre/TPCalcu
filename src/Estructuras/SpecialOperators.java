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

    COS("cos", "#"),
    SEN("sen", "%"),
    TAN("tan", "&"),
    SQRT("sqrt", "$"),
    FACTO("facto", "@");

    private String description, simbol;

    private SpecialOperators(String description, String simbol) {
        this.description = description;
        this.simbol = simbol;
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
    

}
