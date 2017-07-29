package ru.vsprog.springinaction.chapter4;

import ru.vsprog.springinaction.chapter2.PerformanceException;
import ru.vsprog.springinaction.chapter2.Performer;

import javax.inject.Inject;
import javax.inject.Provider;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by vsa
 * Date: 07.11.14.
 */
public class KnifeJuggler implements Performer {
    public KnifeJuggler(Set<Knife> knives) {
        this.knives = knives;
    }

    private Set<Knife> knives;

    @Inject
    public KnifeJuggler(Provider<Knife> knifeProvider) {
        knives = new HashSet<Knife>();
        for (int i = 0; i < 5; i++) {
            knives.add(knifeProvider.get());
        }
    }

    @Override
    public void perform() throws PerformanceException {
        System.out.println("JUGGLING " + knives.size() + " KNIVES");
    }
}