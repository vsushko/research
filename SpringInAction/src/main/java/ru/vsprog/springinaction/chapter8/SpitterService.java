package ru.vsprog.springinaction.chapter8;

import ru.vsprog.springinaction.chapter6.Spitter;

/**
 * Created by vsa
 * Date: 20.11.14.
 */
public interface SpitterService {
    Object getRecentSpittles(int defaultSpittlesPerPage);
    Spitter getSpitter(String username);
    Object getSpittlesForSpitter(String username);
}
