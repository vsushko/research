package studyclass;
 interface Interface {
     void doSomething();
     void somethingElse(String arg);
 }
class RealObject implements Interface {
    public void somethingElse(String arg) {
        System.out.println("somethingElse " + arg);
    }
    public void doSomething() {
        System.out.println("something");
    }
}

class SimpleProxy implements Interface {
    private Interface proxied;
    public SimpleProxy(Interface proxied) {
        this.proxied = proxied;
    }
    public void somethingElse(String arg) {
        System.out.println("SimpleProxy somethingElse " + arg);
        proxied.somethingElse(arg);
    }
    public void doSomething() {
        System.out.println("something");
        proxied.doSomething();
    }
}
 class SimpleProxyDemo {
     public static void consumer(Interface iface) {
         iface.doSomething();
         iface.somethingElse("bnobo");
     }
     public static void main(String[] args) {
         consumer(new RealObject());
         consumer(new SimpleProxy(new RealObject()));
     }
 }