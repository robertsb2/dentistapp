package model.user;

public class UserFactory {
    public static User getInstance(){
        return new UserImpl();
    }

    public static User getInstance(String firstName, String lastName, int userID, String username, String password) {
        return new UserImpl(firstName,lastName,userID,username,password);
    }
}
