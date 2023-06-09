package com.tamagotchi;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;

public class Tamagotchi implements Serializable {
    int lesFood;
    String name;
    int health;
    int happyness; 
    int food;
    int care;
    int state;
    boolean isAlive;
    boolean isSisck;

    public Tamagotchi() {
        name = "";
        health = 0;
        happyness = 0;
        food = 15;
        care = 30;
        isAlive = true;
        isSisck = false;
    }



    public void askeName() {
        System.out.println("Qu'elle sera son nom?");
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader buffer = new BufferedReader(reader);
        String input = buffer.toString();
        try {
            input = buffer.readLine();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            askeName();
        }
        if (input.isEmpty()) {
            try {
                throw new ExceptionTamagotchi(TamagotchiExecptionType.NoName, "noName");
            } catch (ExceptionTamagotchi e) {
                System.out.println(e.getMessage());
                askeName();
            }
        }
        name = input;
        Clear.clearConsole();
    }

   

    public void toilet() {
        // lanch little game who return value between 1 to 100
        this.care += 30; // complit with value return by game
    }

    public void play() {
        if (isAlive) {
            
            this.happyness = this.happyness + 3;
            System.out.println(name + " est heureux ! Joie : " + happyness);
        } else {
            System.out.println(name + " est mort. Vous ne pouvez pas jouer avec lui.");
        }
    }

    public void feed() {
        if (isAlive) {
            food -= 3;
            System.out.println(name + " est nourri ! Faim : " + food);
        } else {
            System.out.println(name + " est mort. Vous ne pouvez pas le nourrir.");
        }
    }


    public void cure() { // add exception if tamagotchi isn't old
        this.isSisck = false;
    }
    
    void SaveTamagotchi(Tamagotchi tamagotchi) {
        LocalDateTime now = LocalDateTime.now();
        long seconds = now.toEpochSecond(java.time.ZoneOffset.UTC);
        // this.lastTime = seconds;
        System.out.println("lastime defin");
        Path path = Path.of("./tamagotchi.dat");
        if (!Files.exists(path)) {
            this.state = 1;
        }
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);

            oos.writeObject(this);
            byte[] data = baos.toByteArray();
            Files.write(Path.of("./tamagotchi.dat"), data);
            oos.close();
            baos.close();
        } catch (IOException e) {
            System.err.println("Quelque chose s'est mal passé durant la sauvegarde : " + e.getMessage());
        }
    }

    public void information() {
        String stateValue = "";
        System.out.println("name:" + this.name);
        System.out.println("health:" + this.health);
        System.out.println("happyness:" + this.happyness);
        System.out.println("care:" + this.care);
        if (this.state == 0) {
            stateValue = "baby";
        } else if (this.state == 1) {
            stateValue = "adult";
        } else if (this.state == 2) {
            stateValue = "old";
        } else if (this.state == 3) {
            stateValue = "dead";
        }
        System.out.println("State:" + stateValue);
     
 
     
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

                return tamagotchi;
            }
        } catch (ClassNotFoundException e) {
            System.err.println("Un problème de compatibilité de la sauvegarde s'est présenté.");
        } catch (IOException e) {
            System.err.println("Quelque chose s'est mal passé durant le chargement du tamagotchi : " + e.getMessage());
        }

        return  new Tamagotchi();

    }
}