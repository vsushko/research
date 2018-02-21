package generaterandom;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Random;
import java.util.Scanner;

class RandomDoubles {
    private static Random rand = new Random();
    public double next() {return rand.nextDouble(); }
}
public class AdaptedRandomDoubles extends RandomDoubles implements Readable {
    private int count;
    public AdaptedRandomDoubles(int count) {
        this.count = count;
    }
    @Override
    public int read(CharBuffer cb) throws IOException {
        if (count-- ==0)
            return -1;
        String result = Double.toString(next()) + " ";
        cb.append(result);
        return result.length();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new AdaptedRandomDoubles(7));
        while (in.hasNextDouble()) {
            System.out.println(in.nextDouble() + " ");
        }
    }
}
