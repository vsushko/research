package ru.vsprog.springinaction.chapter2;

/**
 * Created by vsa
 * Date: 06.11.14.
 */
public class MagicBoxImpl implements MagicBox {
    public MagicBoxImpl() {
    }

    @Override
    public String getContents() {
        return "A beautiful assistant";
    }
}
