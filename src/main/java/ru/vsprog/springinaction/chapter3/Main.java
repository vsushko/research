package ru.vsprog.springinaction.chapter3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by vsa
 * Date: 06.11.14.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-idol.xml");
        RefreshListener refreshListener = (RefreshListener) context.getBean("refreshListener");


    }
}
