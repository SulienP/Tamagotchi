package com.tamgotchi;

import java.nio.file.*;

public class GameManager {
    public void gamemanager()  {

        Path path = Path.of("./SaveTamagotchi.jav");
        if (Files.exists(path)) {
            /*
              TODO récupération du tama
             */

        } else {
            Tamagotchi nameTamagotchi = new Tamagotchi();
                nameTamagotchi.askeName();
 

            Menu menu = new Menu();
            menu.MenuPlay();
            
        }
    } 

      
}
