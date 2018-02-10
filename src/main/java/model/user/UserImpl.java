package model.user;

import model.PersonImpl;
import model.user.User;

public class UserImpl extends PersonImpl implements User {
    private String username;
    private String password;

    public UserImpl() {
    }

    public UserImpl(String firstName, String lastName, int userID, String username, String password) {
        super(firstName, lastName, userID);
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Username: " + this.getUsername();
    }
}
