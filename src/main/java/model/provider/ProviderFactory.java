package model.provider;

public class ProviderFactory {
    public static Provider getInstance(){
        return new ProviderImpl();
    }
}
