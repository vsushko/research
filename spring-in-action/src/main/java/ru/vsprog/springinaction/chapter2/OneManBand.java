package ru.vsprog.springinaction.chapter2;

import java.util.Properties;

/**
 * Created by vsa
 * Date: 05.11.14.
 */
public class OneManBand implements Performer {
//    private Collection<Instrument> instruments;
//    private Map<String, Instrument> instruments;

    Properties instruments;

    public OneManBand() {
    }

    @Override
    public void perform() throws PerformanceException {
//        for (Instrument instrument : instruments) {
//            instrument.play();
//        }
//        for (String key : instruments.keySet()) {
//            System.out.println(key + " : ");
//            Instrument instrument = instruments.get(key);
//            instrument.play();
//        }

        for (Object instrument : instruments.keySet()) {
            String property = (String) instruments.get(instrument);
            System.out.println(property);
        }
    }


    public void setInstruments(Properties instruments) {
        this.instruments = instruments;
    }
}
