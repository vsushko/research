package ru.vsprog.springinaction.chapter2;

/**
 * Created by vsa
 * Date: 05.11.14.
 */
public class Sonnet29 implements Poem {
    private static String[] LINES = {
            "String 1",
            "String 2",
            "String 3"
    };

    @Override
    public void recite() {
        for (String line : LINES) {
            System.out.println(line);
        }
    }
}
