package massives;

import java.util.Arrays;

public class FillingArrays {
    public static void main(String[] args) {
        int size = 6;
        int[] mass = new int[size];
        Arrays.fill(mass, 100);
        System.out.println(Arrays.toString(mass));
    }
}
