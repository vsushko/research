package com.sva.combining.ducks;

/**
 * @author: vsa
 * @date: 26.10.16
 */
public interface QuackObservable {
    void registerObserver(Observer observer);

    void notifyObservers();
}
