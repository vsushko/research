package com.sva.factory.af;

/**
 * @author vsa
 * @created 18.09.16
 */
public class CaliforniaPizzaStore extends PizzaStore {
    @Override
    protected Pizza createPizza(String item) {

        if (item.equals("cheese")) {
            return new CaliforniaStylePizza();
        } else if (item.equals("veggie")) {
            return new CaliforniaStyleVeggiePizza();
        } else if (item.equals("clam")) {
            return new CaliforniaStyleClamPizza();
        } else if (item.equals("pepperoni")) {
            return new CaliforniaStylePepporoniPizza();
        }
        return null;
    }
}
