package model.provider;

public class ProviderFactory {
    public static Provider getInstance(){
        return new ProviderImpl();
    }

    public static Provider getInstance(String firstName, String lastName, int userID, String title){
        return new ProviderImpl(firstName,lastName,userID,title);
    }
}
