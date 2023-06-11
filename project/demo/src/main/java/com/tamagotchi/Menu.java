package com.tamagotchi;
import java.io.InputStreamReader;
import java.util.Objects;
import java.io.BufferedReader;

public class Menu {

    private static final String[] TAMAGOTCHI_MENU = {
            "1. Nourrir",
            "2. Jouer",
            "3. Se soigner",
            "4. Afficher les informations",
            "5. Quitter"
    };
    private static final String[] TAMAGOTCHI_MENU_DEAD = {
            "1. Afficher les informations",
            "2. Sauvegarder",
            "3. Quitter"
    };

    public static String MenuPlay() {
        String [] goodValyue = { "1", "2", "3", "4", "5" };
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader buffer = new BufferedReader(reader);
        System.out.println("Que voulez-vous faire ?");
        for (String string : TAMAGOTCHI_MENU) {
            System.out.println(string);
        }
        try {
            String input = buffer.readLine();
            boolean inputchecking = checkValue(goodValyue, input);
            if (!inputchecking) {
                try {
                    throw new ExceptionTamagotchi(TamagotchiExecptionType.BadValue, "BadValue");
                } catch (ExceptionTamagotchi e) {
                    System.out.println(e.getMessage());
                    GameManager gameManager = new GameManager();
                    gameManager.gamemanager();
                }
            }
            
            switch (input) {
                case "1":
                    return "feed";
                case "2":
                    return "play";
                case "3":
                    return "heal";
                case "4":
                    return "info";
                case "5":
                    return "exit";
                default:
                    return "";
            }
        } catch (Exception e) {
            return "error";
        }
    }

    public static boolean checkValue(String[] goodValue, String input) {
        for (String element : goodValue) {
            if (Objects.equals(element, input)) {
                return true;
            }
        }
        return false;
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
