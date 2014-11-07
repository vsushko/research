package ru.vsprog.springinaction.chapter2;

import org.springframework.stereotype.Component;

/**
 * Created by vsa
 * Date: 05.11.14.
 */
@Component
public class Saxophone implements Instrument {
    public Saxophone() {
    }

    @Override
    public void play() {
        System.out.println("TOOT TOOT TOOT");
    }
}
