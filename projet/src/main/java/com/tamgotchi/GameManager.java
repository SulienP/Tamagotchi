package com.tamgotchi;

import java.nio.file.*;

public class GameManager {
    private boolean isAlreadyCreated = false;
    public void gamemanager()  {

        Path path = Path.of("./SaveTamagotchi.jav");
        
        if (Files.exists(path)) {
            isAlreadyCreated = true;
            /*
              TODO récupération du tama
             */

        } else {
            if (!isAlreadyCreated) {
                Clear.clearConsole();
                Tamagotchi nameTamagotchi = new Tamagotchi();
                nameTamagotchi.askeName();
                System.out.println("Bienvenue dans Tamagotchi");
            }
            String value = Menu.MenuPlay();

            if ("feed".equals(value)) {
                nameTamagotchi.feed();
                System.out.println("Vous avez nourri votre Tamagotchi");
                gamemanager();
            } else if ("wash".equals(value)) {
                nameTamagotchi.toilet();
                System.out.println("Vous avez lavé votre Tamagotchi");
                gamemanager();
            } else if ("heal".equals(value)) {
                nameTamagotchi.cure();
                System.out.println("Vous avez soigné votre Tamagotchi");
                gamemanager();
            } 
        }
    } 

      
}
