package com.sva.factory.af;

/**
 * @author vsa
 * @created 17.09.16
 */
public class ClaimPizza extends Pizza {

    PizzaIngredientFactory ingredientFactory;

    public ClaimPizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }


    @Override
    void prepare() {
        System.out.println("Preparing " + name);
        dough = ingredientFactory.createDough();
        sauce = ingredientFactory.createSauce();
        cheese = ingredientFactory.createCheese();
        clam = ingredientFactory.createClam();

    }
}
