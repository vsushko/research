package ru.vsprog.springinaction.chapter6;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by vsa
 * Date: 13.11.14.
 */
public class Spitter {
    private long id;

    @Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters long.")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Username must be alphanumeric with no spaces")
    private String username;

    @Size(min = 6, max = 20, message = "The password must be at least 6 characters long.")
    private String password;

    @Size(min = 3, max = 50, message = "Your full name must be between 3 and 50 characters long.")
    private String fullName;

    @Pattern(regexp = "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}", message = "Invalid email address.")
    private String email;
    private boolean updateByEmail;

    public Object getUserName() {
        return username;
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

    public long getId() {
        return id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUpdateByEmail(boolean updateByEmail) {
        this.updateByEmail = updateByEmail;
    }

    public boolean isUpdateByEmail() {
        return updateByEmail;
    }
}
