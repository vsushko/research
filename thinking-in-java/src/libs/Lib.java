package libs;

class Lib {
    private Lib() {
        System.out.println("In libs.Lib");
    }
    public static Lib makeLib() {
        return new Lib();
    }
}
