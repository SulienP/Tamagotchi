package com.tamagotchi;

import java.nio.file.*;

public class GameManager {
    public void gamemanager() {

        Path path = Path.of("./SaveTamagotchi.jav");

        if (Files.exists(path)) {
            /*
             * TODO récupération du tama
             */

        } else {
            Tamagotchi nameTamagotchi = new Tamagotchi();
            nameTamagotchi.askeName();
            System.out.println("Bienvenue dans Tamagotchi");
            String value = Menu.MenuPlay();
            Tamagotchi tamagotchimenu = new Tamagotchi();

            if ("feed".equals(value)) {
                tamagotchimenu.feed();
                System.out.println("Vous avez nourri votre Tamagotchi");
            } else if ("wash".equals(value)) {
                tamagotchimenu.toilet();
                System.out.println("Vous avez lavé votre Tamagotchi");
            } else if ("heal".equals(value)) {
                tamagotchimenu.cure();
                System.out.println("Vous avez soigné votre Tamagotchi");
            }
        }
    }

}
