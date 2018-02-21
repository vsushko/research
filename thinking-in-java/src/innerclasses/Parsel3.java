package innerclasses;

interface Destination {
    String readLabel();
}
interface Contents {
    int value();
}
/*
public class Parsel3 {
    class Contents {
        private int i = 11;
        public int value() {return i;}
    }
    class Destination {
        private String label;
        Destination(String whereTo) { label = whereTo; }
        String readLebel() { return label; }
    }
    public static void main(String[] args) {
        Parsel3 p = new Parsel3();
        Parsel3.Contents c = p.new Contents();
        Parsel3.Destination d = p.new Destination("Tanzanya");
    }
}

class Parsel5 {
    public Destination dest(String s) {
        class PDestination implements Destination {
            private String label;
            private PDestination(String whereTo) {
                label = whereTo;
            }
            public String readLabel() { return label; }
        }
        return new PDestination(s);
    }
    public static void main(String[] args) {
        Parsel5 p = new Parsel5();
        Destination d = p.dest("Tasmanya");
    }
}
*/
class Parcel7 {
    public Contents contents() {
        return new Contents() {
            private int i = 11;
            @Override
            public int value() {
                return i;
            }
        };
    }
    public static void main(String[] args) {
        Parcel7 p = new Parcel7();
        Contents c = p.contents();
        System.out.println(c.value());
    }
}