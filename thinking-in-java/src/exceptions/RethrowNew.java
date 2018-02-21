package exceptions;

class OneException extends Exception {
    public OneException(String s) { super(s); }
}
class TwoException extends Exception {
    public TwoException(String s) { super(s); }
}
public class RethrowNew {
    public static void f() throws OneException {
        System.out.print("Create exception in f()\n");
        throw new OneException("from f()");
    }
    public static void main(String[] args) throws TwoException {
        try {
            try {
                f();
            } catch (OneException e) {
                System.out.print("In inner block try\n");
                e.printStackTrace();
                throw new TwoException("From inner block try");
            }
        } catch (Exception e) {}
    }
}
