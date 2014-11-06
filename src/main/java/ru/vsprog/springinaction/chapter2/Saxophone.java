package ru.vsprog.springinaction.chapter2;

/**
 * Created by vsa
 * Date: 05.11.14.
 */
public class Saxophone implements Instrument {
    public Saxophone() {
    }

    @Override
    public void play() {
        System.out.println("TOOT TOOT TOOT");
    }
}
