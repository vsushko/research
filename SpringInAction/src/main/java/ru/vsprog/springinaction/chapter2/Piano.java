package ru.vsprog.springinaction.chapter2;

import org.springframework.stereotype.Component;

/**
 * Created by vsa
 * Date: 05.11.14.
 */
@Component
public class Piano implements Instrument {
    public Piano() {
    }

    @Override
    public void play() {
        System.out.println("Pink Pink Pink");
    }
}
