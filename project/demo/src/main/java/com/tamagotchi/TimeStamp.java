package com.tamagotchi;

import java.util.Timer;
import java.util.TimerTask;


public class TimeStamp {
    public static Integer cycleTime;

    public static void timeStamp(Tamagotchi tamagotchi) {
        Timer timer = new Timer();
        if (tamagotchi.state == 0) {
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    boolean value = tamagotchi.checkCondition();
                    if (value) {
                        timer.cancel();
                        GameManager gameManager = new GameManager();
                        gameManager.gamemanager();
                    }
                }
            };
            // Condition après avoir fais naitre le tamagotchi

            TimerTask task2 = new TimerTask() {
                @Override
                public void run() {
                    tamagotchi.state = 1;
                    System.out.println("state: " + tamagotchi.state);
                }
            };

            timer.schedule(task2, 10000);

            timer.scheduleAtFixedRate(task, 0, 1000);
        }
    }
    
}

