package ru.vsprog.guice;

/**
 * Created by vsa on 17.12.13.
 */
public class DatabaseTransactionLog implements TransactionLog {
    private String jdbcUrl;
    private int threadPoolSize;
    private Connection connection;

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

    public void setJdbcUrl(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }

    public String getJdbcUrl() {
        return jdbcUrl;
    }

    public void setThreadPoolSize(int threadPoolSize) {
        this.threadPoolSize = threadPoolSize;
    }

    public int getThreadPoolSize() {
        return threadPoolSize;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public Connection getConnection() {
        return connection;
    }
}
