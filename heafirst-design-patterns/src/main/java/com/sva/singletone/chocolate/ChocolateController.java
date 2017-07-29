package com.sva.singletone.chocolate;

/**
 * @author vsa
 * @created 18.09.16
 */
public class ChocolateController {

    public static void main(String[] args) {
        ChocolateBoiler boiler = ChocolateBoiler.getInstance();
        boiler.fill();
        boiler.boil();
        boiler.drain();

        // will return the existing instance
        ChocolateBoiler boiler2 = ChocolateBoiler.getInstance();
    }
}
