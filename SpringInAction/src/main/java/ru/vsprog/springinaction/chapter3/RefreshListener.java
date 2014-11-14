package ru.vsprog.springinaction.chapter3;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * Created by vsa
 * Date: 06.11.14.
 */
public class RefreshListener implements ApplicationListener {
    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        System.out.println("Hello");
    }
}
