package com.tamgotchi;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Menu {

    private static final String[] TAMAGOTCHI_MENU = {
        "1. Nourrir",
        "2. Jouer",
        "3. Dormir",
        "4. Se laver",
        "5. Se soigner",
        "6. Afficher les informations",
        "7. Sauvegarder",
        "8. Quitter"
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
                    return "sleep";
                case "4":
                    return "wash";
                case "5":
                    return "heal";
                case "6":
                    return "quit";
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
