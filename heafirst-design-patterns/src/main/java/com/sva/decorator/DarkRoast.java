package com.sva.decorator;

/**
 * @author vsa
 * @created 11.09.16
 */
public class DarkRoast extends Beverage {

    public DarkRoast() {
        description = "Dark Roast";
    }

    @Override
    public double cost() {
        return 0.99;
    }
}
