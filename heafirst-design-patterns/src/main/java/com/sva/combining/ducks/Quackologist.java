package com.sva.combining.ducks;

/**
 * @author: vsa
 * @date: 26.10.16
 */
public class Quackologist implements Observer {

    @Override
    public void update(QuackObservable duck) {
        System.out.println("Quackologist: " + duck + " just quacked.");
    }

    public String toString() {
        return "Quackologist";
    }
}
