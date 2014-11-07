package ru.vsprog.springinaction.chapter3;

/**
 * Created by vsa
 * Date: 06.11.14.
 */
public class LimeImpl implements Lime {
    @Override
    public void drink() {
        System.out.println("Called the doctor woke him up!");
    }
}
