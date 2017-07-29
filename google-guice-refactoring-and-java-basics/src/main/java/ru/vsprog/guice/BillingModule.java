package ru.vsprog.guice;

import com.google.inject.AbstractModule;

/**
 * Created by vsa on 17.12.13.
 */
public class BillingModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(TransactionLog.class).toProvider(DatabaseTransactionProvider.class);
        bind(CreditCardProcessor.class).annotatedWith(PayPal.class).to(PaypalCreditCardProcessor.class);
        bind(BillingService.class).to(ReadBillingService.class);
//        bind(TransactionLog.class).to((Class<? extends TransactionLog>) InMemoryTransactionLog.class).in(Singleton.class);

    }

    /*@Provides @Singleton
    TransactionLog provideTransactionLog() {
        DatabaseTransactionLog transactionLog = new DatabaseTransactionLog();
        transactionLog.setJdbcUrl("asdfjkl;");
        transactionLog.setThreadPoolSize(30);
        return transactionLog;
    }
*/
//    @Provides
//    CreditCardProcessor providePayPalCreditCardProcessor(String apiKey) {
//        PaypalCreditCardProcessor processor = new PaypalCreditCardProcessor();
//        processor.setApiKey(apiKey);
//        return processor;
//    }
}
