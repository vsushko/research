package ru.vsprog.springinaction.chapter8;

import ru.vsprog.springinaction.chapter6.Spitter;
import ru.vsprog.springinaction.chapter7.Spittle;

import java.util.List;

/**
 * Created by vsa
 * Date: 20.11.14.
 */
public interface SpitterService {
    List<Spittle> getRecentSpittles(int count);
    void saveSpittle(Spittle spittle);

    void saveSpitter(Spitter spitter);
    Spitter getSpitter(long id);
    void startFollowing(Spitter follower, Spitter followee);

    List<Spittle> getSpittlesForSpitter(Spitter spitter);
    List<Spittle> getSpittlesForSpitter(String username);
    Spitter getSpitter(String username);

    Spittle getSpittleById(long id);
    void deleteSpittle(long id);

    List<Spitter> getAllSpitters();
}
