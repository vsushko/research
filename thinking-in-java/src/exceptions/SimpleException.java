package exceptions;

public class SimpleException extends Exception {}

class InheritingExceptions {
    public void f() throws  SimpleException {
        System.out.println("Возбуждаем SimpleException из f()");
        throw new SimpleException();
    }
    public static void main(String[] args) {
        InheritingExceptions sed = new InheritingExceptions();
        try {
            sed.f();
        }
        catch (SimpleException e) {
            System.out.print("Перехвачено");
        }
    }
}

