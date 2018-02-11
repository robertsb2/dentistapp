package model.provider;

public class ProviderFactory {
    /**
     * creates instance of a class that implements Provider
     * @return instance
     */
    public static Provider getInstance(){
        return new ProviderImpl();
    }

    /**
     * * creates instance of a class that implements Provider through overloaded constructor
     * @param firstName provider's first name
     * @param lastName provider's last name
     * @param userID provider's unique id
     * @param title provider's title
     * @return instance
     */
    public static Provider getInstance(String firstName, String lastName, int userID, String title){
        return new ProviderImpl(firstName,lastName,userID,title);
    }
}
