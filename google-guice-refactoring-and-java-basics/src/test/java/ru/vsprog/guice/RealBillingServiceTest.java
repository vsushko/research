package ru.vsprog.guice;

import junit.framework.TestCase;

/**
 * Created by vsa on 17.12.13.
 */
public class RealBillingServiceTest extends TestCase {
    private final PizzaOrder order = new PizzaOrder(100);
    private final CreditCard creditCard = new CreditCard("1234", 11, 2020);

    private final TransactionLog transactionLog = new TransactionLog() {
        @Override
        public void logChargeResult(ChargeResult result) {

        }

        @Override
        public void logConnectException(UnreachableException e) {

        }

        @Override
        public boolean wasSuccessLoggerd() {
            return false;
        }
    };
    private final CreditCardProcessor creditCardProcessor = new CreditCardProcessor() {
        @Override
        public ChargeResult charge(CreditCard creditCard, Object getAmount) {
            return null;
        }

        @Override
        public CreditCard getAmountOfOnlyCharge() {
            return null;
        }
    };

    public void testSuccessfulCharge() {
//        ReadBillingService billingService = new ReadBillingService(creditCardProcessor, transactionLog);
//        Receipt receipt = billingService.cargeOrder(order, creditCard);
//
//        assertTrue(receipt.hasSuccessfulCharge());
//        assertEquals(100, receipt.getAmountOfCharge());
//        assertEquals(creditCard, creditCardProcessor.getAmountOfOnlyCharge());
//        assertTrue(transactionLog.wasSuccessLoggerd());
    }
}
