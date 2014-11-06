package ru.vsprog.springinaction.chapter2;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

/**
 * Created by vsa
 * Date: 06.11.14.
 */
public class TigerReplacer implements MethodReplacer {

    @Override
    public Object reimplement(Object o, Method method, Object[] objects) throws Throwable {
        return "A ferocious tiger";
    }
}
