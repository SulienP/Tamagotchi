package com.tamagotchi;

import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Menu {

    private static final String[] TAMAGOTCHI_MENU = {
            "1. Nourrir",
            "2. Jouer",
            "3. Se laver",
            "4. Se soigner",
            "5. Afficher les informations",
            "6. Quitter"
    };
    private static final String[] TAMAGOTCHI_MENU_DEAD = {
            "1. Afficher les informations",
            "2. Sauvegarder",
            "3. Quitter"
    };

    public static String MenuPlay() {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader buffer = new BufferedReader(reader);
        System.out.println("Que voulez-vous faire ?");

        for (String string : TAMAGOTCHI_MENU) {
            System.out.println(string);
        }
        try {
            String input = buffer.readLine();
            switch (input) {
                case "1":
                    return "feed";
                case "2":
                    return "play";
                case "3":
                    return "wash";
                case "4":
                    return "heal";
                case "5":
                    return "info";
                case "6":
                    return "exit";
                default:
                    return "error";
            }
        } catch (Exception e) {
            return "error";
        }
    }

    public static String MenuPlayDead() {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader buffer = new BufferedReader(reader);
        System.out.println("Que voulez-vous faire ?");

        for (String string : TAMAGOTCHI_MENU_DEAD) {
            System.out.println(string);
        }
        try {
            String input = buffer.readLine();
            switch (input) {
                case "1":
                    return "info";
                case "2":
                    return "save";
                case "3":
                    return "quit";
                default:
                    return "error";
            }
        } catch (Exception e) {
            return "error";
        }
    }

}
