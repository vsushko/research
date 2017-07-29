package com.sva.singletone.subclass;

/**
 * @author vsa
 * @created 18.09.16
 */
public class SingletonTestDrive {

    public static void main(String[] args) {
        Singleton foo = CoolerSingleton.getInstance();
        Singleton bar = HotterSingleton.getInstance();
        System.out.println(foo.getDescription());
        System.out.println(bar.getDescription());
    }
}
