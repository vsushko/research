package ru.vsprog.sample;

import ru.vsprog.guice.CreditCard;

/**
 * Created by vsa on 17.12.13.
 */
public class FakeCreditCardProcessor {
    private CreditCard amountOfOnlyCharge;

    public CreditCard getAmountOfOnlyCharge() {
        return amountOfOnlyCharge;
    }
}
