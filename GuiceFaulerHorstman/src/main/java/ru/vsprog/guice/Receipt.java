package ru.vsprog.guice;

/**
 * Created by vsa on 17.12.13.
 */
public class Receipt {
    private int amountOfCharge;

    public static Receipt forSuccessfulCharge(Object getAmount) {
        return null;
    }

    public static Receipt forDeclinedCharge(Object declineMessage) {
        return null;
    }

    public static Receipt forSystemFailure(Object message) {
        return null;
    }

    public boolean hasSuccessfulCharge() {
        return false;
    }

    public int getAmountOfCharge() {
        return amountOfCharge;
    }
}
