package com.tamagotchi;

import java.util.Timer;
import java.util.TimerTask;


public class TimeStamp {
    public static Integer cycleTime;

    public static void timeStamp(Tamagotchi tamagotchi) {
        Timer timer = new Timer();
        Timer bornTamagotchi = new Timer();
        if (tamagotchi.state == 0) {
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    System.out.println("fff");

                    boolean value = tamagotchi.checkCondition();
                    if (value) {
                        timeStamp(tamagotchi);
                    }
                }
            };
            // CCondition pour temps d'éclosion du tamagotchi 

            TimerTask task2 = new TimerTask() {
                @Override
                public void run() {
                    System.out.println("ss");

                    tamagotchi.state = 1;
                    System.out.println("state: " + tamagotchi.state);
                }
            };

            bornTamagotchi.schedule(task2, 10000);

            timer.scheduleAtFixedRate(task, 0, 10000);
        } else {
            timer.cancel();
            bornTamagotchi.cancel();
            System.out.println("state = 1");

            Timer checkConditionForTamagotchi = new Timer();
            TimerTask task3 = new TimerTask() {
                @Override
                public void run() {
                    System.out.println("Une jounrée est passé pour :" + tamagotchi.name);
                    tamagotchi.checkTimerforTamagotchi();
                }
            };
            if (tamagotchi.state == 3) {
                checkConditionForTamagotchi.cancel();
            }
            checkConditionForTamagotchi.scheduleAtFixedRate(task3, 0, 10000);
   
        }

    }
    
}

