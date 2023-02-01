package com.sva.singletone.subclass;

/**
 * @author vsa
 * @created 18.09.16
 */
public class Singleton {

    protected static Singleton uniqueInstance;

    // other useful instance variables here

    protected Singleton() {}

    public static synchronized Singleton getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Singleton();
        }
        return uniqueInstance;
    }

    public String getDescription() {
        return "Default Singleton";
    }

    // other useful methods here
}
