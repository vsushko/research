package ru.vsprog.guice;

/**
 * Created by vsa on 17.12.13.
 */
public class TransactionLogFactory {
    private static DatabaseTransactionLog instance;

    public static void setInstance(DatabaseTransactionLog transactionLog) {
        instance = transactionLog;
    }

    public static DatabaseTransactionLog getInstance() {
        if (instance == null) {
            return new DatabaseTransactionLog();
        }
        return instance;
    }

}