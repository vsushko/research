package ru.vsprog.springinaction.chapter12;

import ru.vsprog.springinaction.chapter6.Spitter;
import ru.vsprog.springinaction.chapter7.Spittle;

public interface SpitterClient {
    Spittle[] retrieveSpittlesForSpitter(String username);

    String postSpitter(Spitter spitter);
}
