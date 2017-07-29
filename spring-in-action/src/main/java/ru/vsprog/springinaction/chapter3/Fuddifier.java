package ru.vsprog.springinaction.chapter3;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Field;

/**
 * Created by vsa
 * Date: 06.11.14.
 */
public class Fuddifier implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        Field[] fields = o.getClass().getDeclaredFields();

        try {
            for (int i = 0; i < fields.length; i++) {
                if (fields[i].getType().equals(String.class)) {
                    fields[i].setAccessible(true);
                    String original = (String) fields[i].get(o);
                    fields[i].set(o, fuddify(original));
                }

            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return o;
    }

    private String fuddify(String orig) {
        if (orig == null) {
            return orig;
        }
        return orig.replaceAll("(r|l)", "w").replaceAll("(R|L)", "W");
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        return null;
    }
}
