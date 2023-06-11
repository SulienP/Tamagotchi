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
import java.util.Random;


public class Tamagotchi implements Serializable {
    String name ="";
    int happyness =15; 
    int food = 1;
    int care= 2;
    int state = 1;
    boolean isAlive = true;
    boolean isSisck= false;
    long cycle = 0;
    int feedCycle = 0;
    int playCycle = 0;
    int caringCycle = 0;
    int cleaningCycle = 0;
    int deadCycle = 0;
    int sickCycle = 0;
    
    public boolean deadCondifiton() {
        if (this.state == 4) {
            Menu.MenuPlayDead();
            return true;
        }
        if (this.happyness <= 0 && this.deadCycle >= 5) {
            Menu.MenuPlayDead();
            return true;
        }
        return false;
    }
    
    public void checkFeed() {
        int lessHapyness = 5;
        if (this.feedCycle >= 0) {
            for (int i = 0; i < this.feedCycle; i++) {
                lessHapyness = lessHapyness + (i * this.feedCycle);
            }
            this.happyness = this.happyness - lessHapyness;
        }
    }
    
    public void checkCondition() {
        if (!deadCondifiton()) {
            checkFeed();
            if (!this.isSisck) {
                if (this.state == 3) {
                    Random random = new Random();
                    int randomNumber = random.nextInt(3) + 1;
                    if (randomNumber > 1) {
                        this.isSisck = true;
                    }
                }
            } else {
                if (this.sickCycle >= 1) {
                    Menu.MenuPlayDead();
                }
            }
        }
    }
    
    public boolean checkUpdateToState2() {
        if (this.state == 1) {
            if(this.feedCycle == 4 && this.happyness >= 40) {
                this.state = 2;
                SaveTamagotchi(this);
                return  true;
            }
        } 
        return false;
        
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
        this.name = input;
        Clear.clearConsole();
    }
    
    
    
    public void toilet() {
        this.care += 3;
        this.happyness += 2;
    }
    
    public void play() {
        
        this.happyness = this.happyness +  3;
        
    }
    
    public void feed() {
        this.food += 3;
        this.happyness = this.happyness+ 1; 
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
    System.out.println("happyness:" + this.happyness);
    System.out.println("care:" + this.care);
    if (this.state == 0) {
        stateValue = "baby";
    } else if (this.state == 1) {
        stateValue = "adult";
    } else if (this.state == 2) {
        stateValue = "old";
    } else if (this.state == 3) {
        stateValue = "old";
    }else if (this.state == 4) {
        stateValue = "dead";
    }
    System.out.println("State:" + stateValue);
    System.out.println("Appuyer sur une touche");
    
    InputStreamReader reader = new InputStreamReader(System.in);
    BufferedReader buffer = new BufferedReader(reader);
    
    try {
        String userInput = buffer.readLine();
    } catch (IOException e) {
        e.printStackTrace();
    } 
}

public void bye() {
    System.out.println("bye");
    System.exit(0);
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