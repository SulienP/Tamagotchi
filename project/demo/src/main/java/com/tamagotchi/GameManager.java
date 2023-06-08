package com.tamagotchi;


import java.nio.file.*;


public class GameManager {
    public static Tamagotchi tamagotchi;
    public  void gamemanager() {
        Path path = Path.of("./tamagotchi.dat");
        if (Files.exists(path)) {
            tamagotchi = tamagotchi.loadTamagotchi();
        } else {
            tamagotchi = new Tamagotchi();
            tamagotchi.askeName();
            System.out.println("Bienvenue dans Tamagotchi");
            TimeStamp.timeStamp(tamagotchi);
        }
        if (tamagotchi.state != 0) {
            System.out.println("je passe au gamemana");
                String value = Menu.MenuPlay();
               if ("wash".equals(value)) {
                    tamagotchi.toilet();
                    System.out.println("Vous avez lavé votre Tamagotchi");
                    gamemanager();
                } else if ("heal".equals(value)) {
                    tamagotchi.cure();
                    System.out.println("Vous avez soigné votre Tamagotchi");
                    gamemanager();

                } else if ("feed".equals(value)) {
                    tamagotchi.feed();
                    System.out.println("Vous avez soigné votre Tamagotchi");
                    gamemanager();

                } else if ("play".equals(value)) {
                    tamagotchi.play();
                    gamemanager();
                    System.out.println("Vous avez joué avec votre Tamagotchi");
                }else if ("info".equals(value)) {
                    tamagotchi.information();
                    gamemanager();
                } else if ("exit".equals(value)) {
                    System.out.println("GoodBye");
                    tamagotchi.SaveTamagotchi(tamagotchi);
                }
            }
        }
    }








    