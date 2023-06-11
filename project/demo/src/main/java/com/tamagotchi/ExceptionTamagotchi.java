package com.tamagotchi;

enum TamagotchiExecptionType {
    NoName,
    BadValue,
    noValue
}

/*
 * Gestion des différentes potentieles exceptions qu'on peut rencontre
 */
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
            case noValue:
                return "Merci de faire le choix entre ligne de command et interface graphique";
            default:
                return "Erreur inconnue";
        }
    }
}
