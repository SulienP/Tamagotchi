package com.tamagotchi;

import java.nio.file.*;


public class GameManager {
    static boolean wantExit = false;
    public static Tamagotchi tamagotchi;

    public static void gamemanager() {
        if (wantExit) {
            tamagotchi.SaveTamagotchi(tamagotchi);
            tamagotchi.bye();
        } else {
            Path path = Path.of("./tamagotchi.dat");
            if (Files.exists(path)) {
                tamagotchi = tamagotchi.loadTamagotchi();
            } else {
                tamagotchi = new Tamagotchi();
                tamagotchi.askeName();
                System.out.println("Bienvenue dans Tamagotchi");
                tamagotchi.state = 1;
                tamagotchi.SaveTamagotchi(tamagotchi);
                System.out.println(tamagotchi.name);

            }
            if (tamagotchi.state != 0) {
                String value = Menu.MenuPlay();
                if ("wash".equals(value)) {
                    tamagotchi.toilet();
                    System.out.println("Vous avez lavé votre Tamagotchi");
                    //  tamagotchi.checkTimerforTamagotchi("wash");

                } 
                if (!tamagotchi.isAlive) {
                    if ("heal".equals(value)) {
                        System.out.println("Votre tamagotchi est en pleine forme");

                    }
                } else {
                    if ("heal".equals(value)) {
                        System.out.println("Votre tamagotchi est en pleine forme");
                        tamagotchi.cure();
                    }
                }
                 if ("feed".equals(value)) {
                    tamagotchi.feed();
                    System.out.println("Vous avez nourri votre Tamagotchi");
                    //  tamagotchi.checkTimerforTamagotchi("feed");

                } else if ("play".equals(value)) {
                    tamagotchi.play();

                    //    tamagotchi.happyness +=3;
                    System.out.println("Vous avez joué avec votre Tamagotchi" + tamagotchi.happyness);

                    //gamemanager();
                } else if ("info".equals(value)) {
                    tamagotchi.information();

                } else if ("exit".equals(value)) {
                    System.out.println("icicicà");
                    wantExit = true;
                }
                tamagotchi.SaveTamagotchi(tamagotchi);
                tamagotchi = tamagotchi.loadTamagotchi();
                // tamagotchi.information();
                // Clear.clearConsole();
                gamemanager();
               
            }

        }
    }
}








