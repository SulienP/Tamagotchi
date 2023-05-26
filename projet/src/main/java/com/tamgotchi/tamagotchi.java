package com.tamgotchi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tamagotchi {
    String name = "";
    int age = 0;
    int food = 30;
    int health = 50;
    int happyness = 30;
    int care = 30;
    int state = 0;
    boolean isAlive = true;
    int tiredness = 20;
    boolean sick = false;

    void askeName() {
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
    }
     
    void tamagotchi(String name) {
        System.out.println(name);
        this.name=name;
    }
    
    public void toilet(){
        //lanch little game who return value between 1 to 100
        this.care+=30; //complit with value return by game
    }

    public void feed(){
        //lanch little game who return value between 1 to 100
        this.food+= 30; //complit with value return by game
    }

    public void cure(){ //add exception if tamagotchi isn't old
        this.sick=false;
    }
}