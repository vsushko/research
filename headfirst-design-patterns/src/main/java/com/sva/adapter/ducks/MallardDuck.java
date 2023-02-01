package com.sva.adapter.ducks;

/**
 * @author: vsa
 * @date: 10.10.16
 */
public class MallardDuck implements Duck {

    @Override
    public void quack() {
        System.out.println("Quack");
    }

    @Override
    public void fly() {
        System.out.println("I'm flying");
    }
}
