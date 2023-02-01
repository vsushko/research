package com.sva.factory.af;

/**
 * @author vsa
 * @created 17.09.16
 */
public class NYStyleClaimPizza extends Pizza {
    NYPizzaIngredientFactory ingredientFactory;

    public NYStyleClaimPizza(NYPizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }

    public NYStyleClaimPizza() {
        name = "NY Style Pepperoni Pizza";
        dough = new ThinCrustDough();
        sauce = new MarinaraSauce();

        toppings.add("Grated Reggiano Cheese");
        toppings.add("Sliced Pepperoni");
        toppings.add("Garlic");
        toppings.add("Onion");
        toppings.add("Mushrooms");
        toppings.add("Red Pepper");
    }

    @Override
    void prepare() {
        System.out.println("Preparing " + name);
        dough = ingredientFactory.createDough();
        sauce = ingredientFactory.createSauce();
    }
}
