package model;

public class PersonImpl implements Person{
    private String firstName;
    private String lastName;
    private int userID;

    /**
     * default constructor
     */
    public PersonImpl() {
    }

    /**
     * overloaded constructor
     * @param firstName Person's first name
     * @param lastName Person's last name
     * @param userID Person's unique id
     */
    public PersonImpl(String firstName, String lastName, int userID) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setUserID(userID);
    }

    /**
     *
     * @return Person's user id
     */
    public int getUserID() {
        return userID;
    }

    /**
     * sets Person's user id
     * @param userID unique id
     */
    public void setUserID(int userID) {
        if (userID < 0){
            throw new IllegalArgumentException("user id cannot be negative");
        }
        this.userID = userID;
    }

    /**
     *
     * @return Person's first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * sets Person's first name
     * @param firstName name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     *
     * @return Person's last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * sets Person's last name
     * @param lastName name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * test to see if two people are equal
     * @param o second person
     * @return boolean based on results
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof PersonImpl)) return false;
        PersonImpl person = (PersonImpl) o;
        return this.getFirstName().equals(person.getFirstName()) &&
                this.getLastName().equals(person.getLastName()) &&
                this.getUserID() == person.getUserID();
    }

    /**
     *
     * @return Person's info as a string
     */
    @Override
    public String toString() {
        return  "First Name: " + this.getFirstName() + '\n' +
                "Last Name: " + this.getLastName();


    }
}
