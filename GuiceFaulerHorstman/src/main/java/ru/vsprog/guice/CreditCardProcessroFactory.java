package ru.vsprog.guice;

/**
 * Created by vsa on 17.12.13.
 */
public class CreditCardProcessroFactory {
    private static CreditCardProcessor instance;

    public static void setInstance(CreditCardProcessor creditCardProcessor) {
        instance = creditCardProcessor;
    }

    public static CreditCardProcessor getInstance() {
        if (instance == null) {
            return new SquareCreditCardProcessor();
        }
        return instance;
    }
}
