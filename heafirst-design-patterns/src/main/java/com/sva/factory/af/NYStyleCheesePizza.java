package com.sva.factory.af;

/**
 * @author vsa
 * @created 17.09.16
 */
public class NYStyleCheesePizza extends Pizza {

    NYPizzaIngredientFactory ingredientFactory;

    public NYStyleCheesePizza(NYPizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }

    public NYStyleCheesePizza() {
        name = "NY Style Sauce and Cheese Pizza";
        dough = new ThinCrustDough();
        sauce = new MarinaraSauce();

        toppings.add("Grated Reggiano Cheese");
        toppings.add("Fresh Clams from Long Island Sound");
    }

    @Override
    void prepare() {
        System.out.println("Preparing " + name);
        dough = ingredientFactory.createDough();
        sauce = ingredientFactory.createSauce();
    }
}
