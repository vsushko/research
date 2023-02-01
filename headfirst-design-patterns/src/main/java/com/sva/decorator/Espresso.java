package com.sva.decorator;

/**
 * @author vsa
 * @created 11.09.16
 */
public class Espresso extends Beverage {

    public Espresso() {
        description = "Espresso";
    }

    @Override
    public double cost() {
        return 1.99;
    }
}
