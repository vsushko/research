package com.sva.templatemethod.simplebarista;

/**
 * @author: vsa
 * @date: 13.10.16
 */
public class Tea extends CaffeineBeverage {

    public void brew() {
        System.out.println("Steeping the tea");
    }

    public void addCondiments() {
        System.out.println("Adding Lemon");
    }

}
