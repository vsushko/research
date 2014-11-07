package ru.vsprog.springinaction.chapter2;

import org.springframework.beans.factory.annotation.Configurable;

/**
 * Created by vsa
 * Date: 05.11.14.
 */
// при настройке экземлпяра класса instrumentalist фреймворк Spring
// будет использовать определение компонента pianist как шаблон
@Configurable("pianist")
public abstract class Instrumentalist implements Performer {
    public Instrument instrument;
    private String song;
    private String age;

    public Instrumentalist() {
    }

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }

    @Override
    public void perform() throws PerformanceException {
        System.out.println("Playing " + song + " : ");
        instrument.play();
    }

    public void setInstrument(Instrument instrument) {
        this.instrument = instrument;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAge() {
        return age;
    }

    public abstract Instrument getInstrument(); // Внедряемый метод
}
