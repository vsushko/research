package ru.vsprog.guice;

/**
 * Created by vsa on 17.12.13.
 */
public class SquareCreditCardProcessor implements CreditCardProcessor {
    @Override
    public ChargeResult charge(CreditCard creditCard, Object getAmount) {
        return null;
    }

    @Override
    public CreditCard getAmountOfOnlyCharge() {
        return null;
    }
}
