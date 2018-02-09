package model;

public class PersonImpl implements Person{
    private String firstName;
    private String lastName;
    private int userID;

    public PersonImpl() {
    }

    public PersonImpl(String firstName, String lastName, int userID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userID = userID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof PersonImpl)) return false;
        PersonImpl person = (PersonImpl) o;
        return this.getFirstName().equals(person.getFirstName()) &&
                this.getLastName().equals(person.getLastName()) &&
                this.getUserID() == person.getUserID();
    }

    @Override
    public String toString() {
        return  "First Name: " + this.getFirstName() + '\n' +
                "Last Name: " + this.getLastName() + '\n';


    }
}
