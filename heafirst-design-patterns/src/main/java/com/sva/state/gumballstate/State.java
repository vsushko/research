package com.sva.state.gumballstate;

/**
 * @author: vsa
 * @date: 21.10.16
 */
public interface State {

    void insertQuarter();

    void ejectQuarter();

    void turnCrank();

    void dispense();

    void refill();
}
