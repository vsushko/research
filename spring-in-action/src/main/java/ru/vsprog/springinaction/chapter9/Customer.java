package ru.vsprog.springinaction.chapter9;

import java.io.Serializable;

/**
 * Created by vsa
 * Date: 26.11.14.
 */
public class Customer implements Serializable {
    private String phoneNumber;

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
