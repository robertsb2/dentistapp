package model.user;

public class UserFactory {
    /**
     * creates instance of a class that implements User
     * @return instance
     */
    public static User getInstance(){
        return new UserImpl();
    }
    /**
     * creates instance of a class that implements User overloaded constructor
     * @param firstName User's first name
     * @param lastName User's last name
     * @param userID User's unique id
     * @param username User's username
     * @param password User's password
     * @return instance
     */
    public static User getInstance(String firstName, String lastName, int userID, String username, String password) {
        return new UserImpl(firstName,lastName,userID,username,password);
    }
}
