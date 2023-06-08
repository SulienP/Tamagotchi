package com.tamagotchi;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.*;


public class GameManager {
    public static Tamagotchi tamagotchi;
    public  void gamemanager() {
        Path path = Path.of("./tamagotchi.dat");
        if (Files.exists(path)) {
            tamagotchi = loadTamagotchi();

        } else {
            tamagotchi = new Tamagotchi();
            tamagotchi.askeName();
            System.out.println("Bienvenue dans Tamagotchi");
            TimeStamp.timeStamp(tamagotchi);
        }

        if (tamagotchi.state != 0) {
            while (tamagotchi.state != 3) {
                String value = Menu.MenuPlay();
                if ("feed".equals(value)) {
                    tamagotchi.feed();
                    System.out.println("Vous avez nourri votre Tamagotchi");
                } else if ("wash".equals(value)) {
                    tamagotchi.toilet();
                    System.out.println("Vous avez lavé votre Tamagotchi");
                } else if ("heal".equals(value)) {
                    tamagotchi.cure();
                    System.out.println("Vous avez soigné votre Tamagotchi");
                } else if ("play".equals(value)) {
                    tamagotchi.play();
                    System.out.println("Vous avez joué avec votre Tamagotchi");
                }else if ("info".equals(value)) {
                    tamagotchi.information();
                } else  {

                    break; // Sortie de la boucle si aucune option valide n'est sélectionnée
                }
            }
        }
    }



    public static Tamagotchi loadTamagotchi() {
        try {
            Path filePath = Path.of("./tamagotchi.dat");
            if (Files.exists(filePath)) {
                byte[] data = Files.readAllBytes(filePath);
                ByteArrayInputStream bais = new ByteArrayInputStream(data);
                ObjectInputStream ois = new ObjectInputStream(bais);
                Tamagotchi tamagotchi = (Tamagotchi) ois.readObject();
                bais.close();
                ois.close();
                // Integer cycles = TimeStamp.GetNumberOfCycle(tamagotchi);
                // for(int i = 0; i<cycles; i++){
                // tamagotchi.nextcycle();
                // }
                return tamagotchi;
            }
        } catch (ClassNotFoundException e) {
            System.err.println("Un problème de compatibilité de la sauvegarde s'est présenté.");
        } catch (IOException e) {
            System.err.println("Quelque chose s'est mal passé durant le chargement des livres : " + e.getMessage());
        }
        return new Tamagotchi();
    }

}


    