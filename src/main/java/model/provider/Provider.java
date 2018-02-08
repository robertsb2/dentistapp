package model.provider;

import model.Person;

public interface Provider extends Person {
    public String getTitle();

    public void setTitle(String title);
}
