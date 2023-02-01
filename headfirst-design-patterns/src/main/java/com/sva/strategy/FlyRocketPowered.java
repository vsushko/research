package com.sva.strategy;

/**
 * @author: vsa
 * @date: 21.07.16
 */
public class FlyRocketPowered implements FlyBehavior {

    public void fly() {
        System.out.printf("I'm flying with a rocket!");
    }
}
