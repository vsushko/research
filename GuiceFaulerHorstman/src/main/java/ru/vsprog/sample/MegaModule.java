package ru.vsprog.sample;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

/**
 * Created by vsa on 13.12.13.
 */
public class MegaModule extends AbstractModule {

    // bind - привязывает интерфейс к реализации
    @Override
    protected void configure() {
        bind(MyMegaInterface.class).to(MegaImplementation.class);
        bind(MyMegaInterface.class).annotatedWith(Puper.class).to(SuperImplementation.class);
        bind(MegaMain.class).in(Singleton.class);
    }
}
