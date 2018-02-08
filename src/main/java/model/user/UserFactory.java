package model.user;

public class UserFactory {
    public static User getInstance(){
        return new UserImpl();
    }
}
