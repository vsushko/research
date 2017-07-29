package com.sva.strategy;

/**
 * @author: vsa
 * @date: 19.07.16
 */
public class FlyNoWay implements FlyBehavior {
    public void fly() {
        System.out.printf("I can't fly");
    }
}
