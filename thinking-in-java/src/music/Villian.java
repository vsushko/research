package music;

enum Note {
    MIDDLE_C,
    C_SHARP,
    B_FLAT;
}
/*
abstract class music.Instrument {
    private int anInt;
    public abstract void play(music.Note n);
    public abstract void adjust();
    public String what() { return "music.Instrument"; }
}
*/
interface Instrument {
    int VALUE = 5;
    void play(Note n);
    void adjust();
}
class Wind implements Instrument {
    public void play(Note n) {
        System.out.println("wind.play()" + n);
    }
    public String what() {
        return "music.Wind";
    }
    public void adjust() {
        System.out.println(this + ".adjust()");
    }
}

class Stringed implements Instrument {
    public void play(Note n) {
        System.out.println("stringed.play()" + n);
    }
    public String what() {
        return "music.Stringed";
    }
    public void adjust() {
        System.out.println(this + ".adjust()");
    }
}

class Brass extends Wind {
    public String toString() { return "music.Brass"; }
}
class WoodWind extends Wind {
    public String toString() { return "Woodwind"; }
}
class Music {
    public static void tune(Instrument i) {
        // ...
        i.play(Note.MIDDLE_C);
    }
    /*
    public static void main(String[] args) {
        music.Wind flute = new music.Wind();
        tune(flute); // Восходящее преобразование
    }*/
}

class Music2 {
    public static void tune(Wind i) {
        i.play(Note.MIDDLE_C);
    }
    public static void tune(Stringed i) {
        i.play(Note.B_FLAT);
    }
    public static void tune(Brass i) {
        i.play(Note.C_SHARP);
    }
    public static void main(String[] args) {
        Wind flute = new Wind();
        Stringed violin = new Stringed();
        Brass frenchHorn = new Brass();
        tune(flute);
        tune(violin);
        tune(frenchHorn);
    }
}

class Music4 {
    static void tune(Instrument i) {
        //
        i.play(Note.MIDDLE_C);
    }
    static void tuneAll(Instrument[] e) {
        for (Instrument i: e)
            tune(i);
    }
    public static void main(String[] args) {
        // Восходящее преобразование при добавлении в массив
        Instrument[] orchestra = {new Wind(), new Stringed(), new Brass(), new WoodWind() };
        tuneAll(orchestra);
    }
}

class Music5 {
    static void tune(Instrument i) {
        //
        i.play(Note.MIDDLE_C);
    }
    static void tuneAll(Instrument[] e) {
        for (Instrument i: e)
            tune(i);
    }
    public static void main(String[] args) {
        // Восходящее преобразование при добавлении в массив
        Instrument[] orchestra = {new Wind(), new Stringed(), new Brass(), new WoodWind() };
        tuneAll(orchestra);
    }
}