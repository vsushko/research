package com.sva.singletone.stat;

/**
 * @author vsa
 * @created 18.09.16
 */
public class SingletonClient {

    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        System.out.println(singleton.getDescription());
    }
}
