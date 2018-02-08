package model.provider;

import model.PersonImpl;
import model.provider.Provider;

public class ProviderImpl extends PersonImpl implements Provider {
    private String title;

    public ProviderImpl() {
    }

    public ProviderImpl(String firstName, String lastName, int userID, String title) {
        super(firstName, lastName, userID);
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Title: " + this.getTitle();
    }
}
