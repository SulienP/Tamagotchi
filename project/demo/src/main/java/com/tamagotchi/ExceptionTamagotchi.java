package com.tamagotchi;

enum TamagotchiExecptionType {
    NoName,
    BadValue
}

public class ExceptionTamagotchi extends Exception {
    TamagotchiExecptionType execptionType = TamagotchiExecptionType.NoName;
    String cause = "";

    public ExceptionTamagotchi(TamagotchiExecptionType execptionType, String cause) {
        super("");
        this.execptionType = execptionType;
        this.cause = cause;
    }

    public String getMessage() {
        switch (execptionType) {
            case NoName:
                return "Merci de mrentrer un nom";
            case BadValue:
                return "Merci d'entrer une valeur correcte";
            default:
                return "Erreur inconnue";
        }
    }
}
