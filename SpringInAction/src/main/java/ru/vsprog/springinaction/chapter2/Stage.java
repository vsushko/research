package ru.vsprog.springinaction.chapter2;

/**
 * Created by vsa
 * Date: 05.11.14.
 */
public class Stage {
    private Stage() {
    }

    private static class StageSingletonHolder {
        static Stage instance = new Stage();
    }

    public static Stage getInstance() {
        return StageSingletonHolder.instance;
    }
}
