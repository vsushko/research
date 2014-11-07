package ru.vsprog.springinaction.chapter4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.vsprog.springinaction.chapter2.PerformanceException;
import ru.vsprog.springinaction.chapter2.Performer;

/**
 * Created by vsa
 * Date: 07.11.14.
 */
public class Main {
    public static void main(String[] args) throws PerformanceException {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        Performer performer = (Performer) context.getBean("poeticDuke");
        performer.perform();
    }
}
