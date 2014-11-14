package ru.vsprog.springinaction.chapter2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by vsa
 * Date: 05.11.14.
 */
public class Main {
    public static void main(String[] args) throws PerformanceException {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-idol.xml");
        Performer performer = (Performer) context.getBean("harry");
        performer.perform();

//        Poem sonnet29 = new Sonnet29();
//        Performer duke = new PoeticJuggler(15, sonnet29);
//        duke.perform();
    }
}
