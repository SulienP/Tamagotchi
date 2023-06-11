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
import java.time.temporal.ChronoUnit;
import java.util.Random;


/*
  * Classe du tamagotchi, ocmprend une méthode pour vérifier les conditions de  jeu + sauvegarde et chargement du tama + les différentes options du jeu
 */
public class Tamagotchi implements Serializable {
    String name ="";
    int happyness =15; 
    int food = 1;
    int care= 2;
    int state = 0;
    boolean isAlive = true;
    boolean isSisck= false;
    long cycle = 0;
    int feedCycle = 0;
    int playCycle = 0;
    int caringCycle = 0;
    int cleaningCycle = 0;
    int deadCycle = 0;
    int sickCycle = 0;
    long timeNoww = 0;
    long lastTime = 0;
    int timeValue = 30;
    
    // check dead condition
    public boolean deadCondifiton() {
        if (this.state == 4) {
            this.isAlive = false;
            Menu.MenuPlayDead();
            return true;
        }
        if (this.happyness <= 0 && this.deadCycle >= 5) {
            this.isAlive = false;

            Menu.MenuPlayDead();
            return true;
        }
        return false;
    }
    
    // check les conditions de nourriture
    public void checkFeed() {
        int lessHapyness = 5;
        if (this.feedCycle >= 0) {
            for (int i = 0; i < this.feedCycle; i++) {
                lessHapyness = lessHapyness + (i * this.feedCycle);
            }
            this.happyness = this.happyness - lessHapyness;
        }
    }
    
 // check les différentes condition

 public void checkCondition() {
     checkAllCondition();
     if (!deadCondifiton()) {
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

    // check tte les conditions manque celel du temps
    private void checkAllCondition() {
        long lessValue = 0;
        LocalDateTime now = LocalDateTime.now();
        long seconds = now.truncatedTo(ChronoUnit.SECONDS).toEpochSecond(null);

        this.timeNoww = seconds;
        lessValue = (this.timeNoww - this.lastTime);
        /*
          TODO: vérifier les cycles entre deux connection
         */
        if (lessValue > 1) {
            this.feedCycle += 1;
            this.playCycle = 1;
        }
        checkFeed();
        if (this.playCycle >= 3) {
            this.happyness -= 2;
        }

    }
    // check si phase 2 ok
    public boolean checkUpdateToState2() {
        if (this.state == 1) {
            if (this.feedCycle == 4 && this.happyness >= 40) {
                this.state = 2;
                SaveTamagotchi(this);
                return true;
            }
        }
        return false;

    }
    // demande du nom du tama
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
    
    
    // Aciton du tama
    public void toilet() {
        
        this.care += 3;
        this.happyness += 2;
    }
    
    public void play() {
        this.playCycle = 0;
        this.happyness = this.happyness +  3;
        
    }
    
    public void feed() {
                this.feedCycle = 0;
        this.food += 3;
        this.happyness = this.happyness+ 1; 
    }
    
    
    
    public void cure() {
        this.caringCycle = 0;
        this.isSisck = false;
    }


    // Sauvegarde et chargement du tam
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

// Montre toute les informations 
public void information() {
    String stateValue = "";
    System.out.println("name:" + this.name);
    System.out.println("happyness:" + this.happyness);
    System.out.println("care:" + this.care);
    System.out.println("food:" + this.food);

    if (this.state == 0) {
        stateValue = "baby";
    } else if (this.state == 1) {
        stateValue = "young";
    } else if (this.state == 2) {
        stateValue = "adult";
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
// sorti du tama
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