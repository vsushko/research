package studyclass;

class Base {}
class Derived extends Base {}


public class FamilyVsExactType {
    static void test(Object x) {
        System.out.println("Test x type " + x.getClass());
        System.out.println("x instance of Base " + (x instanceof Base));
    }
    public static void main(String[] args) {
        test(new Base());
        test(new Derived());
    }
}
