package model.user;

import model.Person;

import java.io.Serializable;

public interface User extends Person {
    String getUsername();

    void setUsername(String username);

    String getPassword();

    void setPassword(String password);

    @Override
    String toString();
}