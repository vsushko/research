package ru.vsprog.springinaction.chapter5;

/**
 * Created by vsa
 * Date: 10.11.14.
 */
public class Volunteer implements Thinker {
    private String thoughts;

    @Override
    public void thinkOfSomething(String thoughts) {
        this.thoughts = thoughts;
    }

    public String getThoughts() {
        return thoughts;
    }
}
