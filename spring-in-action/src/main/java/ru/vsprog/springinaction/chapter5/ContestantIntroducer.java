package ru.vsprog.springinaction.chapter5;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

/**
 * Created by vsa
 * Date: 10.11.14.
 */
@Aspect
public class ContestantIntroducer {

    // внедрение интерфейса Contestant
    @DeclareParents(value = "ru.vsprog.springinaction.chapter2.Performer+",
                    defaultImpl = GraciousContestant.class)
    public static Contestant contestant;

}
