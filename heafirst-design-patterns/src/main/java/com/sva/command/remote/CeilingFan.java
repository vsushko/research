package com.sva.command.remote;

/**
 * @author vsa
 * @created 20.09.16
 */
public class CeilingFan {

    public static final int HIGH = 3;
    public static final int MEDIUM = 1;
    public static final int LOW = 0;
    int level;
    private String location = "";

    public CeilingFan(String location) {
        this.location = location;
    }

    public void high() {
        // turns the ceiling fan on to high
        level = HIGH;
        System.out.println(location + " ceiling fan is on high");
    }

    public void medium() {
        // turns the ceiling fan on to medium
        level = MEDIUM;
        System.out.println(location + " ceiling fan is on medium");
    }

    public void low() {
        // turns the ceiling fan on to low
        level = LOW;
        System.out.println(location + " ceiling fan is on low");
    }

    public void off() {
        // turns the ceiling fan off
        level = 0;
        System.out.println(location + " ceiling fan is off");
    }

    public int getSpeed() {
        return level;
    }


}
