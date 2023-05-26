package com.tamgotchi;

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

     
    void tamagotchi(String name){
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
