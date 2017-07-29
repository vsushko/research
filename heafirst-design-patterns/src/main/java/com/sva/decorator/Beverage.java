package com.sva.decorator;

/**
 * @author vsa
 * @created 11.09.16
 */
public abstract class Beverage {

    String description = "Unknown Beverage";

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}
