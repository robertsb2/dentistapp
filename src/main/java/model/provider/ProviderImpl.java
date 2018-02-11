package model.provider;

import model.PersonImpl;
import model.provider.Provider;

public class ProviderImpl extends PersonImpl implements Provider {
    private String title;

    /**
     * default constructor
     */
    public ProviderImpl() {
    }

    /**
     * overloaded constructor
     * @param firstName provider's first name
     * @param lastName provider's last name
     * @param userID provider's unique id
     * @param title provider's title
     */
    public ProviderImpl(String firstName, String lastName, int userID, String title) {
        super(firstName, lastName, userID);
        this.setTitle(title);
}

    /**
     *
     * @return provider's title
     */
    public String getTitle() {
        return title;
    }

    /**
     * sets provider's title
     * @param title provider's title
     */
    public void setTitle(String title) {
        if (!title.equalsIgnoreCase("dentist") &&
                !title.equalsIgnoreCase("dental assistant") &&
                !title.equalsIgnoreCase("dental hygienist")){
            throw new IllegalArgumentException("invalid provider title");
        }
        this.title = title;
    }

    /**
     *
     * @return provider's info as a string
     */
    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Title: " + this.getTitle();
    }
}
