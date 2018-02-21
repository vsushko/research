package libs;

class Lib2 {
    private static Lib2 lib2 = new Lib2();

    private Lib2() {
        System.out.print("In libs.Lib2");
    }

    public static Lib2 access() {
        return lib2;
    }
}
