package ru.vsprog.springinaction.chapter2;

/**
 * Created by vsa
 * Date: 05.11.14.
 */
public class Piano implements Instrument {
    public Piano() {
    }

    @Override
    public void play() {
        System.out.println("Pink Pink Pink");
    }
}
