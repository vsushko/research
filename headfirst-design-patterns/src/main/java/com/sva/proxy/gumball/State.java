package com.sva.proxy.gumball;

import java.io.Serializable;

/**
 * @author: vsa
 * @date: 23.10.16
 */
public interface State extends Serializable {
    void insertQuarter();

    void ejectQuarter();

    void turnCrank();

    void dispense();
}