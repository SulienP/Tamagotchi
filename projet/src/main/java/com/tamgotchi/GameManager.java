package com.tamgotchi;

import java.nio.file.*;

public class GameManager {
    private Tamagotchi nameTamagotchi;

    public void gamemanager()  {

        Path path = Path.of("./SaveTamagotchi.jav");
        
        if (Files.exists(path)) {
            /*
              TODO récupération du tama
             */

        } else {
            nameTamagotchi = new Tamagotchi();
            nameTamagotchi.askeName();            
            System.out.println("Bienvenue dans Tamagotchi");
            Menu menu = new Menu();
            String value = menu.MenuPlay();
            
            if (value == "feed") {
                nameTamagotchi.feed();
                System.out.println("Vous avez nourri votre Tamagotchi");
            } else if (value == "wash") {
                nameTamagotchi.toilet();
                System.out.println("Vous avez lavé votre Tamagotchi");
            } else if (value == "heal") {
                nameTamagotchi.cure();
                System.out.println("Vous avez soigné votre Tamagotchi");
            } 
        }
    } 


    public void SaveTamagotchi(){
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(nameTamagotchi);
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
                Tamagotchi nameTamagotchi = (Tamagotchi) ois.readObject();
                bais.close();
                ois.close();
                return nameTamagotchi;
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
