package com.sva.templatemethod.barista;

/**
 * @author: vsa
 * @date: 12.10.16
 */
public class Coffee extends CaffeineBeverage {

    public void brew() {
        System.out.println("Dripping Coffee through filter");
    }

    public void addCondiments() {
        System.out.println("Adding Sugar and Milk");
    }

}
