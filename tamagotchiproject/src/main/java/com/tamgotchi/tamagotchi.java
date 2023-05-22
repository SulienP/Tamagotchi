package com.tamgotchi;

public class tamagotchi {
    String name;
    int age;
    int food;
    int health;
    int happyness;
    int care;
    int state;
    boolean isAlive;
    int tiredness;
    
    public void toilet(){
        //lanch little game who return value between 1 to 100
        this.care+=30; //complit with value return by game
       
    }

    public void feed(){
        //lanch little game who return value between 1 to 100
        this.food+= 30; //complit with value return by game
    }
}
