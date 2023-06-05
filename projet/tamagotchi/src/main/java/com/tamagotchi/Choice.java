package com.tamagotchi;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Choice {
    public String choice() {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader buffer = new BufferedReader(reader);
        System.out.println("Que voulez-vous faire, jouer avce une interface (1)ou en ligne de commande(2)?");
        return buffer.toString();
    } 
}
