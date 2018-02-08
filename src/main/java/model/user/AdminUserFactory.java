package model.user;

public class AdminUserFactory {


    public static AdminUser getInstance() {
        return new AdminUserImpl();
    }
}
