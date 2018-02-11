package model.user;

public class AdminUserImpl extends UserImpl implements AdminUser {
    /**
     * default constructor
     */
    public AdminUserImpl() {

    }

    /**
     * overloaded constructor
     * @param firstName User's first name
     * @param lastName User's last name
     * @param userID User's unique id
     * @param username User's username
     * @param password User's password
     */
    public AdminUserImpl(String firstName, String lastName, int userID, String username, String password) {
        super(firstName, lastName, userID, username, password);
    }

    /**
     *
     * @return Administrator User info as a string
     */
    @Override
    public String toString() {
        return super.toString();
    }
}
