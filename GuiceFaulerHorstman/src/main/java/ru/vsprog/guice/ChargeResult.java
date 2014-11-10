package ru.vsprog.guice;

/**
 * Created by vsa on 17.12.13.
 */
public class ChargeResult {
    private Object declineMessage;

    public boolean wasSuccessful() {
        return false;
    }

    public Object getDeclineMessage() {
        return declineMessage;
    }
}
