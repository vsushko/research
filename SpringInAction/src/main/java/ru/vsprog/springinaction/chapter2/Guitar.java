package ru.vsprog.springinaction.chapter2;

import org.springframework.stereotype.Component;

/**
 * Created by vsa
 * Date: 07.11.14.
 */
//@Qualifier("stringed")
//@StringedInstrument
@Component
public class Guitar implements Instrument {

    public Guitar() {
    }

    @Override
    public void play() {
        System.out.println("Strum strum strum");
    }
}
