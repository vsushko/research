package ru.vsprog.springinaction.chapter7;

import ru.vsprog.springinaction.chapter6.Spitter;

/**
 * Created by vsa
 * Date: 19.11.14.
 */
public class Spittle {
    private Spitter spitter;
    private Object id;
    private Object text;

    public Spitter getSpitter() {
        return spitter;
    }

    public void setSpitter(Spitter spitter) {
        this.spitter = spitter;
    }

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public Object getText() {
        return text;
    }

    public void setText(Object text) {
        this.text = text;
    }
}
