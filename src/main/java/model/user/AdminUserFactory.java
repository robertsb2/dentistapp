package model.user;

public class AdminUserFactory {

    /**
     * creates instance of a class that implements AdminUser
     * @return instance
     */
    public static AdminUser getInstance() {
        return new AdminUserImpl();
    }

    /**
     * creates instance of a class that implements AdminUser overloaded constructor
     * @param firstName User's first name
     * @param lastName User's last name
     * @param userID User's unique id
     * @param username User's username
     * @param password User's password
     * @return instance
     */
    public static AdminUser getInstance(String firstName, String lastName, int userID, String username, String password){
        return new AdminUserImpl(firstName,lastName,userID,username,password);
    }
}
