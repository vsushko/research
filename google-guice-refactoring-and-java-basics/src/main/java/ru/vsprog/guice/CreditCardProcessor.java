package ru.vsprog.guice;

import com.google.inject.ImplementedBy;

@ImplementedBy(PaypalCreditCardProcessor.class)
public interface CreditCardProcessor {
    public ChargeResult charge(CreditCard creditCard, Object getAmount);

    public CreditCard getAmountOfOnlyCharge();
}
