package ru.vsprog.springinaction.chapter17;

import ru.vsprog.springinaction.chapter7.Spittle;

public interface SpitterEmailService {
    void sendSpittleEmail(String to, Spittle spittle);
}
