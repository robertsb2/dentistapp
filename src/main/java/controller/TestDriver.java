package controller;

import model.user.AdminUser;
import model.user.AdminUserFactory;
import model.user.User;
import model.user.UserFactory;

public class TestDriver {

    public static void main(String[] args) {
        AdminUser temp = AdminUserFactory.getInstance();
        User temp2 = UserFactory.getInstance();

    }

}
