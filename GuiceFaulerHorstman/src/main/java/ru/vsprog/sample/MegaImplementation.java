package ru.vsprog.sample;

/**
 * Created by vsa on 13.12.13.
 */
public class MegaImplementation implements MyMegaInterface {

    public MegaImplementation() {
        System.out.println("Megaimplementation constructor");
    }

    @Override
    public void run() {
        System.out.println("Mega implementation run");
    }
}
