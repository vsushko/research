package ru.vsprog.springinaction.chapter6;

/**
 * Created by vsa
 * Date: 13.11.14.
 */
public class Spitter {
    private Object userName;
    private Object password;
    private Object fullName;
    private Object email;
    private long id;
    private String username;

    public Object getUserName() {
        return userName;
    }

    public Object getPassword() {
        return password;
    }

    public Object getFullName() {
        return fullName;
    }

    public Object getEmail() {
        return email;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
