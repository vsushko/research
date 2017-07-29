package ru.vsa.guava;

import java.util.Objects;

/**
 * Created by vsa
 * Date: 24.03.2015.
 */
public class Student {
    private String firstName;
    private String lastName;
    private int rollNo;
    private String className;

    public Student(String firstName, String lastName, int rollNo, String className) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.rollNo = rollNo;
        this.className = className;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Student) || object == null) {
            return false;
        }
        Student student = (Student) object;
        return Objects.equals(firstName, student.firstName)
                && Objects.equals(lastName, student.lastName)
                && Objects.equals(rollNo, student.rollNo)
                && Objects.equals(className, student.className);
    }

    @Override
    public int hashCode() {
        return Objects.hash(className, rollNo);
    }
}
