package model.user;

import model.PersonImpl;

public class AdminUserImpl extends PersonImpl implements AdminUser {

    private String username;
    private String password;

    public AdminUserImpl() {

    }

    public AdminUserImpl(String firstName, String lastName, int userID, String username, String password) {
        super(firstName, lastName, userID);
        this.setUsername(username);
        this.setPassword(password);
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

    public boolean changePassword(String pass, String newPass, User user) {
        if(this.getPassword().equals(pass)){
            user.setPassword(newPass);
            return true;
        }
        return false;
    }
}
