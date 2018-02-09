package model;

import java.io.Serializable;

public interface Person extends Serializable {
    int getUserID();

    void setUserID(int userID);

    String getFirstName();

    void setFirstName(String firstName);

    String getLastName();

    void setLastName(String lastName);

    @Override
    boolean equals(Object o);

    @Override
    String toString();
}
