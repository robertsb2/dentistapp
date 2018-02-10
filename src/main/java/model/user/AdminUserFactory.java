package model.user;

public class AdminUserFactory {


    public static AdminUser getInstance() {
        return new AdminUserImpl();
    }

    public static AdminUser getInstance(String firstName, String lastName, int userID, String username, String password){
        return new AdminUserImpl(firstName,lastName,userID,username,password);
    }
}
