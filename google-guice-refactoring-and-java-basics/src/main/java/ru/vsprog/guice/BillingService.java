package ru.vsprog.guice;

/**
 * Created by vsa on 17.12.13.
 */
public interface BillingService {
    Receipt cargeOrder(PizzaOrder order, CreditCard creditCard);

    Receipt cargeOrder(Object pizzaOrder, Object creditCard);
}
