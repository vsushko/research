package ru.vsprog.guice;

import com.google.inject.Singleton;

@Singleton
public class InMemoryTransactionLog {
    public boolean wasSuccessLoggerd() {
        return false;
    }
}
