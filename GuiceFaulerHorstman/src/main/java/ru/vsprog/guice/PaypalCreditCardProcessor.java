package ru.vsprog.guice;

import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * Created by vsa on 17.12.13.
 */
public class PaypalCreditCardProcessor implements CreditCardProcessor {
    private String apiKey;

    @Inject
    public PaypalCreditCardProcessor(@Named("PayPal API Key" )String apiKey) {
        this.apiKey = apiKey;
    }

    @Override
    public ChargeResult charge(CreditCard creditCard, Object getAmount) {
        return null;
    }

    @Override
    public CreditCard getAmountOfOnlyCharge() {
        return null;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getApiKey() {
        return apiKey;
    }
}
