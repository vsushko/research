package com.sva.adapter.ducks;

/**
 * @author: vsa
 * @date: 10.10.16
 */
public class WildTurkey implements Turkey {

    @Override
    public void gobble() {
        System.out.println("Gobble gobble");
    }

    @Override
    public void fly() {
        System.out.println("I'm flying a short distance");
    }
}
