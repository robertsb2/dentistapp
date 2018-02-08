package model;

public interface Person {
    public int getUserID();

    public void setUserID(int userID);

    public String getFirstName();

    public void setFirstName(String firstName);

    public String getLastName();

    public void setLastName(String lastName);

    @Override
    public boolean equals(Object o);

    @Override
    public String toString();
}
