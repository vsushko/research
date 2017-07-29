package ru.vsprog.sample;

import com.google.inject.BindingAnnotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.METHOD;

/**
 * Created by vsa on 13.12.13.
 */
@BindingAnnotation
@Target({FIELD, PARAMETER, METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Puper {
}
