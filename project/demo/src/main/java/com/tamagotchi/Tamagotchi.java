package com.tamagotchi;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;

public class Tamagotchi implements Serializable {
    String name = "";
    int food = 30;
    int health = 50;
    int happyness = 0;
    int care = 30;
    int state = 0;
    boolean isAlive = true;
    int tiredness = 20;
    boolean isSisck = false;
    int cycle = 1;
    int lastTimetamp = 0;
    int playByCycle = 0;
    int washByCycle = 0;
    int feedByCycle = 0;

    public boolean checkCondition() {
        if (this.state == 0) {
            System.out.println("votre tamagotchi va naitre");
            return false;
        } else {
            this.state = 1;
            System.out.println("votre tamagotchi est né");
            SaveTamagotchi(this);

            return true;
        }
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
        tamagotchi(input);
        Clear.clearConsole();
    }

    void sleeping() {
        happyness += 10;
    }
    void tamagotchi(String name) {
        System.out.println(name);
        this.name = name;
    }

    public void toilet() {
        // lanch little game who return value between 1 to 100
        this.care += 30; // complit with value return by game
    }

    public void play() {
        this.happyness += 20;
    }
    public void feed() {
        // lanch little game who return value between 1 to 100
        this.food += 30; // complit with value return by game
    }

    public void cure() { // add exception if tamagotchi isn't old
        this.isSisck = false;
    }
    
    void SaveTamagotchi(Tamagotchi tamagotchi) {
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
        System.out.println("feed:" + this.food);
        System.out.println("health:" + this.health);
        System.out.println("happyness:" + this.happyness);
        System.out.println("care:" + this.care);
        if (this.state == 0) {
            stateValue = "baby";
        }else if(this.state == 1) {
            stateValue = "young";
        } else if (this.state == 2) {
            stateValue = "adult";
        } else if (this.state == 3) {
            stateValue = "dead";
        }
        System.out.println("State:" + this.state);
        System.out.println("tiredness:" + this.tiredness);
        System.out.println("isSisck:" + this.isSisck);

    }
}