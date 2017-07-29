package ru.vsprog.guice;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * Created by vsa on 17.12.13.
 */
public abstract class ReadBillingService implements BillingService {
    private final CreditCardProcessor processor;
    private final TransactionLog transactionLog;

    @Inject
    public ReadBillingService(@PayPal CreditCardProcessor processor, TransactionLog transactionLog) {
        this.processor = processor;
        this.transactionLog = transactionLog;
    }

    public Receipt cargeOrder(PizzaOrder order, CreditCard creditCard) {
        ChargeResult result = processor.charge(creditCard, order.getAmount);
        transactionLog.logChargeResult(result);

        return result.wasSuccessful() ? Receipt.forSuccessfulCharge(order.getAmount)
                : Receipt.forDeclinedCharge(result.getDeclineMessage());
    }

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new BillingModule());
        // billingService - граф объектов
        BillingService billingService = injector.getInstance(BillingService.class);

        billingService.cargeOrder(new PizzaOrder(10), new CreditCard("1233", 1, 2014)).getAmountOfCharge();
        billingService.cargeOrder(new PizzaOrder(10), new CreditCard("1233", 1, 2014)).hasSuccessfulCharge();
    }

}
