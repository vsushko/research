package com.sva.strategy;

/**
 * @author: vsa
 * @date: 19.07.16
 */
public class MuteQuack implements QuackBehavior {

    public void quack() {
        System.out.printf("<< Silence >>");
    }
}
