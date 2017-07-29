package com.sva.facade;

/**
 * @author: vsa
 * @date: 12.10.16
 */
public class PopcornPopper {

    String description;

    public PopcornPopper(String description) {
        this.description = description;
    }

    public void on() {
        System.out.println(description + " on");
    }

    public void off() {
        System.out.println(description + " off");
    }

    public void pop() {
        System.out.println(description + " popping popcorn!");
    }


    public String toString() {
        return description;
    }
}
