package model.user;

import model.Person;

public interface User extends Person {
    String getUsername();

    void setUsername(String username);

    String getPassword();

    void setPassword(String password);
}