package massives;


import generic.Generator;

import java.util.Random;

public class RandomGenerator {
    private static Random r = new Random(47);
    public static class Boolean implements Generator<java.lang.Boolean> {
        public java.lang.Boolean next() {
            return r.nextBoolean();
        }
    }
    public static class Byte implements Generator<java.lang.Byte> {
        public java.lang.Byte next() {
            return (byte)r.nextInt();
        }
    }
    static char[] chars = ("abcdefghigklmnopqrstuvwxyz").toCharArray();
    public static class Character implements Generator<java.lang.Character> {
        int index = -1;
        public java.lang.Character next() {
            index = (index + 1) % chars.length;
            return chars[index];
        }
    }
}
