package com.tamagotchi;

import java.nio.file.*;


public class GameManager {
    public static Tamagotchi tamagotchi;
    public static  void gamemanager() {
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
               
            } else if ("heal".equals(value)) {
                tamagotchi.cure();
                System.out.println("Vous avez soigné votre Tamagotchi");
               //  tamagotchi.checkTimerforTamagotchi("heal");
               
                
            } else if ("feed".equals(value)) {
                tamagotchi.feed();
                System.out.println("Vous avez soigné votre Tamagotchi");
               //  tamagotchi.checkTimerforTamagotchi("feed");
                
               
                
            } else if ("play".equals(value)) {
                tamagotchi.play();
                
                               //  tamagotchi.checkTimerforTamagotchi("play");
                               tamagotchi.happyness +=3;
                System.out.println("Vous avez joué avec votre Tamagotchi" + tamagotchi.happyness);
               
                gamemanager();
            } else if ("info".equals(value)) {
                tamagotchi.information();
                
               
                
            } else if ("exit".equals(value)) {
                System.out.println("GoodBye");
                tamagotchi.SaveTamagotchi(tamagotchi);
            }
        }
       
    }   
}








