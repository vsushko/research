package com.sva.singletone.subclass;

/**
 * @author vsa
 * @created 18.09.16
 */
public class CoolerSingleton extends Singleton {

    // useful instance variables here
    protected static Singleton uniqueInstance;

    private CoolerSingleton() {
        super();
    }

    public String getDescription() {
        return "Cooler Singleton";
    }

    // useful methods here
}
