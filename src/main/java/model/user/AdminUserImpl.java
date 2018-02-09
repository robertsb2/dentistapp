package model.user;

import model.PersonImpl;

public class AdminUserImpl extends UserImpl implements AdminUser {

    private String username;
    private String password;

    public AdminUserImpl() {

    }

    public AdminUserImpl(String firstName, String lastName, int userID, String username, String password) {
        super(firstName, lastName, userID, username, password);
    }

}
