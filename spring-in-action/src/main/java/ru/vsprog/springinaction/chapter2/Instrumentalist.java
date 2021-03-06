package ru.vsprog.springinaction.chapter2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by vsa
 * Date: 05.11.14.
 */
// при настройке экземлпяра класса instrumentalist фреймворк Spring
// будет использовать определение компонента pianist как шаблон
//@Configurable("pianist")
@Component("eddie")
public class Instrumentalist implements Performer {

    // при аннотировании поля, можно избавить от методов записи
    //@Autowired
    //@Autowired(required = false)
    // если компонентов несколько, помогаем определить
//    @Qualifier("stringed")
//    @Autowired
    //@StringedInstrument
    //@Inject
    //Named("guitar")
    public Instrument instrument;

    //@Value("Eruption")
    @Value("#{systemProperties.myFavoriteSong}")
    private String song;
    private String age;

    //@Autowired
    protected Instrumentalist(Instrument instrument) {
        this.instrument = instrument;
    }

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

    //@Autowired
    public void setInstrument(Instrument instrument) {
        this.instrument = instrument;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAge() {
        return age;
    }

//    public abstract Instrument getInstrument(); // Внедряемый метод
}
