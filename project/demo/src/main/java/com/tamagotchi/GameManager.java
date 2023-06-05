package com.tamagotchi;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.*;
import java.security.Timestamp;

public class GameManager {
    private static Tamagotchi tamagotchi;
    private Integer time;

    public static void gamemanager()  {

        Path path = Path.of("./SaveTamagotchi.jav");
        
        if (Files.exists(path)) {
            /*
              TODO récupération du tama
             */

        } else {
            tamagotchi = new Tamagotchi();
            tamagotchi.askeName();            
            System.out.println("Bienvenue dans Tamagotchi");
            Menu menu = new Menu();
            String value = menu.MenuPlay();
            
            if (value == "feed") {
                tamagotchi.feed();
                System.out.println("Vous avez nourri votre Tamagotchi");
            } else if (value == "wash") {
                tamagotchi.toilet();
                System.out.println("Vous avez lavé votre Tamagotchi");
            } else if (value == "heal") {
                tamagotchi.cure();
                System.out.println("Vous avez soigné votre Tamagotchi");
            } 
        }
    } 


    public void SaveTamagotchi(){
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(tamagotchi);
            byte[] data = baos.toByteArray();
            Files.write(Path.of("./tamagotchi.dat"), data);
            oos.close();
            baos.close();
        }
        catch(IOException e){
            System.err.println("Quelque chose s'est mal passé durant la sauvegarde : " + e.getMessage());
        }
    }

    public static Tamagotchi loadTamagotchi(){
        try {
            Path filePath = Path.of("./tamagotchi.dat");
            if(Files.exists(filePath)){
                byte[] data = Files.readAllBytes(filePath);
                ByteArrayInputStream bais = new ByteArrayInputStream(data);
                ObjectInputStream ois = new ObjectInputStream(bais);
                Tamagotchi tamagotchi = (Tamagotchi) ois.readObject();
                bais.close();
                ois.close();
                return tamagotchi;
            }
        }
        catch (ClassNotFoundException e){
            System.err.println("Un problème de compatibilité de la sauvegarde s'est présenté.");
        }
        catch(IOException e){
            System.err.println("Quelque chose s'est mal passé durant le chargement des livres : " + e.getMessage());
        }
        return new Tamagotchi();
    }

      
}


    