package model.user;


public interface AdminUser extends User {

    String getUsername();

    void setUsername(String username);

    String getPassword();

    void setPassword(String password);

    int getUserID();

    void setUserID(int userID);

    String getFirstName();

    void setFirstName(String firstName);

    String getLastName();

    void setLastName(String lastName);

    boolean equals(Object o);

    String toString();
}
