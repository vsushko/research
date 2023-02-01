package com.sva.templatemethod.simplebarista;

/**
 * @author: vsa
 * @date: 13.10.16
 */
public class Barista {

    public static void main(String[] args) {

        Tea tea = new Tea();
        System.out.println("Making tea...");
        tea.prepareRecipe();

        Coffee coffee = new Coffee();
        System.out.println("Making coffee...");
        coffee.prepareRecipe();
    }
}
