package com.sva.combining.ducks;

/**
 * @author: vsa
 * @date: 26.10.16
 */
public class DecoyDuck implements Quackable {
    Observable observable;

    public DecoyDuck() {
        observable = new Observable(this);
    }

    public void quack() {
        System.out.println("<< Silence >>");
        notifyObservers();
    }

    public void registerObserver(Observer observer) {
        observable.registerObserver(observer);
    }

    public void notifyObservers() {
        observable.notifyObservers();
    }

    public String toString() {
        return "Decoy Duck";
    }
}
