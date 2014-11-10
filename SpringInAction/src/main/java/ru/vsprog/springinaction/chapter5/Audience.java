package ru.vsprog.springinaction.chapter5;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * Created by vsa
 * Date: 10.11.14.
 */
@Aspect
public class Audience {
    public Audience() {
    }

    @Pointcut("execution(* ru.vsprog.springinaction.chapter2.Performer.perform(..))")
    public void performance() {
    }

    // перед выступлением
    @Before("performance()")
    public void takeSeats() {
        System.out.println("The audience is taking their seats.");
    }

    // перед выступлением
    @Before("performance()")
    public void turnOffCellPhones() {
        System.out.println("clap clap clap clap clap");
    }

    // после выступления
    @AfterReturning("performance()")
    public void applaud() {
        System.out.println("clap clap clap clap clap");
    }

    // после неудачного выступления
    @AfterThrowing("performance()")
    public void demandRefund() {
        System.out.println("Boo! We want our money back!");
    }

    @Around("performance()")
    public void watchPerformance(ProceedingJoinPoint joinPoint) {
        try {
            System.out.println("The audience is taking their seats.");
            System.out.println("The audience is turning off their cellphones.");

            long start = System.currentTimeMillis();
            joinPoint.proceed();
            long end = System.currentTimeMillis();

            System.out.println("clap clap clap clap clap");

            System.out.println("The performance took " + (end-start) + " milliseconds.");
        } catch (Throwable throwable) {
            System.out.println("Boo! We want our money back!");
        }
    }

}
