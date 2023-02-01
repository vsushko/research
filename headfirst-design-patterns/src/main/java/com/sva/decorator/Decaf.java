package com.sva.decorator;

/**
 * @author vsa
 * @created 11.09.16
 */
public class Decaf extends Beverage {

    public Decaf() {
        description = "Decaf";
    }

    @Override
    public double cost() {
        return 1.05;
    }
}
