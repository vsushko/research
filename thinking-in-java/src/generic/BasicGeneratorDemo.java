package generic;

class CountedObject {
    private static long counter = 0;
    private final long id = counter++;
    public long id() {
        return id;
    }
    public String toString() {
        return "CountedObject " + id;
    }
}
public class BasicGeneratorDemo {
    public static void main(String[] args) {
        //Generator<CountedObject> gen = new BasicGeneratorDemo.main();
    }
}
