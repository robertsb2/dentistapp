package model.user;

import model.PersonImpl;


import java.util.regex.Pattern;

public class UserImpl extends PersonImpl implements User {
    private String username;
    private String password;

    /**
     * default constructor
     */
    public UserImpl() {
    }

    /**
     * overloaded constructor
     * @param firstName User's first name
     * @param lastName User's last name
     * @param userID User's unique id
     * @param username User's username
     * @param password User's password
     */
    public UserImpl(String firstName, String lastName, int userID, String username, String password) {
        super(firstName, lastName, userID);
        this.setUsername(username);
        this.setPassword(password);
    }

    /**
     *
     * @return  User's username
     */
    public String getUsername() {
        return username;
    }

    /**
     * sets User's username
     * @param username User's username
     */
    public void setUsername(String username) {
        if (username.isEmpty()) {
            throw new IllegalArgumentException("username cannot be empty");
        }
        this.username = username;
    }

    /**
     *
     * @return User's password
     */
    public String getPassword() {
        return password;
    }

    /**
     * sets User's password
     * password must be at least 8 characters long and contain the following:
     * 1 number
     * 1 lowercase letter
     * 1 uppercase letter
     * 1 special character (@#$%^&+=)
     * @param password User's password
     */
    public void setPassword(String password) {
        if (!Pattern.matches("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}",password)){
            throw new IllegalArgumentException("password does not meet minimum requirements");
        }
        this.password = password;
    }

    /**
     *
     * @return User's info as a string
     */
    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Username: " + this.getUsername();
    }
}
