package ru.vsprog.springinaction.chapter9;

import org.apache.commons.lang.WordUtils;

import java.util.Arrays;
import java.util.List;

/**
 * Created by vsa
 * Date: 26.11.14.
 */
public enum PaymentType {
    CASH, CHECK, CREDIT_CARD;

    public static List<PaymentType> asList() {
        PaymentType[] all = PaymentType.values();
        return Arrays.asList(all);
    }

    @Override
    public String toString() {
        return WordUtils.capitalizeFully(name().replace('_', ' '));
    }
}
