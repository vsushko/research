package com.sva.factory.af;

/**
 * @author vsa
 * @created 17.09.16
 */
public class NYStylePepperoniPizza extends Pizza {

    NYPizzaIngredientFactory ingredientFactory;

    public NYStylePepperoniPizza(NYPizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }

    @Override
    void prepare() {

    }
}
