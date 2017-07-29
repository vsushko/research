package com.sva.decorator;

/**
 * @author vsa
 * @created 11.09.16
 */
public class HouseBlend extends Beverage {

    public HouseBlend() {
        description = "House Blend Coffee";
    }

    @Override
    public double cost() {
        return 0.89;
    }
}
