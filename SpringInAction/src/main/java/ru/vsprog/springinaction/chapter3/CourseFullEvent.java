package ru.vsprog.springinaction.chapter3;

import org.springframework.context.ApplicationEvent;

/**
 * Created by vsa
 * Date: 06.11.14.
 */
public class CourseFullEvent extends ApplicationEvent {
    private Course course;

    public CourseFullEvent(Object source, Course course) {
        super(source);
        this.course = course;
    }

    public Course getCourse() {
        return course;
    }
}
