package ru.vsprog.guice;

import com.google.inject.ProvidedBy;

@ProvidedBy(DatabaseTransactionProvider.class)
public interface TransactionLog {
    public void logChargeResult(ChargeResult result);

    public void logConnectException(UnreachableException e);

    public boolean wasSuccessLoggerd();
}
