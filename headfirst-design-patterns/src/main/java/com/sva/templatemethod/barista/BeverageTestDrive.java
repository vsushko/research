package com.sva.templatemethod.barista;

/**
 * @author: vsa
 * @date: 13.10.16
 */
public class BeverageTestDrive {

    public static void main(String[] args) {

        TeaWithHook teaWithHook = new TeaWithHook();
        System.out.println("\nMaking tea...");
        teaWithHook.prepareRecipe();

        CoffeeWithHook coffeeWithHook = new CoffeeWithHook();
        System.out.println("\nMaking coffee...");
        coffeeWithHook.prepareRecipe();
    }
}
