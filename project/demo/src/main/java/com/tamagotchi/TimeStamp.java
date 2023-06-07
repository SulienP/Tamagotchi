package com.tamagotchi;

public class TimeStamp {
    public static Integer cycleTime;
    public static Integer getTimeStamp(){
        return (int) (System.currentTimeMillis() / 1000);
    }
    public static Integer GetNumberOfCycle(Tamagotchi tamagotchi){
        Integer timestamp = getTimeStamp();
        timestamp-=tamagotchi.lastTimetamp;
        timestamp/=cycleTime;
        return timestamp;
    }

}
