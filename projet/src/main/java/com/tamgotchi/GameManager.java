package com.tamgotchi;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.*;

public class GameManager {
    public void gamemanager() {
        Path path = Path.of("./tamagotchi.dat");
        System.out.println(path);
        System.out.println(Files.exists(path));
        if (Files.exists(path)) {
            Clear.clearConsole();
            Tamagotchi tamagotchiLoad = loadTamagotchi();
            String value = Menu.MenuPlay();
            if ("feed".equals(value)) {
                tamagotchiLoad.feed();
                System.out.println("appuyer sur un touche");
                gamemanager();
            } else if ("wash".equals(value)) {
                tamagotchiLoad.toilet();
                System.out.println("Vous avez lavé votre tamagotchi");
                gamemanager();
            } else if ("heal".equals(value)) {
                tamagotchiLoad.cure();
                System.out.println("Vous avez soigné votre tamagotchi");
                gamemanager();
            } else if ("play".equals(value)) {
                gamemanager();
            } else if ("sleep".equals(value)) {
                gamemanager();
            } else if ("save".equals(value)) {
                saveTamagotchi(tamagotchiLoad);
                System.out.println("You tamagotchi is save, Good bye");
            }else if("quit".equals(value)) {
                saveTamagotchi(tamagotchiLoad);
                System.out.println("Good bye");
        } else {
            System.out.println("Bienvenue dans tamagotchi");
            Tamagotchi tamagotchi = new Tamagotchi();
            tamagotchi.askeName();
            saveTamagotchi(tamagotchi);
            gamemanager();
        }
    } 


    public void saveTamagotchi(Tamagotchi tamagotchi){
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
