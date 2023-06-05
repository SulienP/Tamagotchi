package com.tamagotchi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Choice {
    public static String start() {
        System.out.println("Vous voulez jouer avec une interface 1 ou un ligne de commande");
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader buffer = new BufferedReader(reader);
        String input = buffer.toString();
        try {
            input = buffer.readLine();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            start();
        }
        if (input.isEmpty()) {
            try {
                throw new ExceptionTamagotchi(TamagotchiExecptionType.NoName, "noName");
            } catch (ExceptionTamagotchi e) {
                System.out.println(e.getMessage());
                start();

            }
        }
        Clear.clearConsole();

        return input;
    }


}
