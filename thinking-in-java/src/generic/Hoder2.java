package generic;

public class Hoder2 {
    private Object a;

    public Hoder2(Object a) {
        this.a = a;
    }
    public void set(Object a) {
        this.a = a;
    }
    public Object get() {
        return a;
    }
    public static void main(String[] args) {
        Hoder2 h2 = new Hoder2(new Automobile());
        Automobile a = (Automobile)h2.get();
        h2.set("He Automobile");
        String s = (String)h2.get();
        System.out.println((String)h2.get());
        h2.set(1);
        Integer x = (Integer)h2.get();
        System.out.println((Integer)h2.get());
    }
}

class Automobile { }
