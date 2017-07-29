package ru.vsprog.guice;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * Created by vsa on 18.12.13.
 */
public class DatabaseTransactionProvider implements Provider<TransactionLog> {
    private final Connection connection;

    @Inject
    public DatabaseTransactionProvider(Connection connection) {
        this.connection = connection;
    }

    @Override
    public TransactionLog get() {
        DatabaseTransactionLog transactionLog = new DatabaseTransactionLog();
        transactionLog.setConnection(connection);
        return transactionLog;
    }
}
