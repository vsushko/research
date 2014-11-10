package ru.vsprog.springinaction.chapter5;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by vsa
 * Date: 10.11.14.
 */
@Aspect
public class Magician implements MindReader {
    private String thoughts;

    // Объявление параметризованного среза множетва точек сопряжения
    @Pointcut("execution(* ru.vsprog.springinaction.chapter5.Thinker." +
            "thinkOfSomething(String)) && args(thoughts)")
    public void thiking(String thoughts) {
    }

    @Override
    // Передача параметра в совет
    @Before("thiking(thoughts)")
    public void interceptThoughts(String thoughts) {
        System.out.println("Intercepting volunteer's thoughts");
        this.thoughts = thoughts;
    }

    @Override
    public String getThoughts() {
        return thoughts;
    }
}
