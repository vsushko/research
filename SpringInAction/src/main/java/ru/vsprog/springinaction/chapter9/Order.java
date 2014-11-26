package ru.vsprog.springinaction.chapter9;

import java.io.Serializable;
import java.util.List;

/**
 * Created by vsa
 * Date: 26.11.14.
 */
public class Order implements Serializable {
    private Customer customer;
    private List<Pizza> pizzas;
    private Payment payment;

    public Order(Customer customer, List<Pizza> pizzas) {
        this.customer = customer;
        this.pizzas = pizzas;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public void setPizzas(List<Pizza> pizzas) {
        this.pizzas = pizzas;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
