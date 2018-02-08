package model.user;

import model.Person;

public interface AdminUser extends Person {

    public String getUsername();

    public void setUsername(String username);

    public String getPassword();

    public void setPassword(String password);

    boolean changePassword(String pass, String newPass, User user);
}
