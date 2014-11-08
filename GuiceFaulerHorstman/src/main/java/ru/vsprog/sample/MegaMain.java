package ru.vsprog.sample;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * Created by vsa on 13.12.13.
 */
public class MegaMain {
    private final MyMegaInterface mega;
    private final MyMegaInterface puper;

    @Inject
    public MegaMain(MyMegaInterface mega, @Puper MyMegaInterface puper) {
        this.mega = mega;
        this.puper = puper;
        System.out.println("MegaMain instance constructor");
    }

    public static void main(String[] args) {
        // создаем инжектор на основе конфигурированного модуля
        Injector injector = Guice.createInjector(new MegaModule());
        MegaMain main = injector.getInstance(MegaMain.class);
        main.mega.run();
        main.puper.run();
    }
}
