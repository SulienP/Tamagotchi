package com.tamgotchi;

import java.nio.file.*;

public class GameManager {
    public void gamemanager() {

        Path path = Path.of("./SaveTamagotchi.jav");
        
        if (Files.exists(path)) {
            /*
              TODO récupération du tama
             */

        } else {
            System.out.println("Bienvenue dans Tamagotchi");
            Menu menu = new Menu();
            String value = menu.MenuPlay();
            Tamagotchi tamagotchimenu = new Tamagotchi();
            
            if (value == "feed") {
                tamagotchimenu.feed();
                System.out.println("Vous avez nourri votre Tamagotchi");
            } else if (value == "wash") {
                tamagotchimenu.toilet();
                System.out.println("Vous avez lavé votre Tamagotchi");
            } else if (value == "heal") {
                tamagotchimenu.cure();
                System.out.println("Vous avez soigné votre Tamagotchi");
            } 
        }
    } 

      
}
