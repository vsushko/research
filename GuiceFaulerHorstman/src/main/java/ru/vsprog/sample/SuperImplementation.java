package ru.vsprog.sample;

/**
 * Created by vsa on 13.12.13.
 */
public class SuperImplementation implements MyMegaInterface{
    public SuperImplementation() {
        System.out.println("SuperImplementation constructor");
    }

    @Override
    public void run() {
        System.out.println("Super");
    }
}
