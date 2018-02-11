package model.patient;

import model.PersonImpl;

import java.util.regex.Pattern;


public class PatientImpl extends PersonImpl implements Patient {
    private String phone;
    private String email;
    private Insurance insurance;
    private long cardNumber;
    private PatientAccount account;
    private final long MIN_CARD_NUMBER = 1000000000000000L;
    private final long MAX_CARD_NUMBER = 9999999999999999L;

    /**
     * default constructor
     * creates new patient account
     */
    public PatientImpl() {
        this.setAccount(new PatientAccount());
        this.setInsurance(InsuranceFactory.getInstance("None",0,0));
    }

    /**
     * overloaded constructor
     * @param firstName patient's first name
     * @param lastName patient's last name
     * @param userID patient's unique id number
     * @param phone patient's phone number
     * @param email patient's email
     */
    public PatientImpl(String firstName, String lastName, int userID, String phone, String email) {
        super(firstName, lastName, userID);
        this.setPhone(phone);
        this.setEmail(email);
        this.setAccount(new PatientAccount());
        this.setInsurance(InsuranceFactory.getInstance("None",0,0));
    }

    /**
     *
     * @return patient's phone number
     */
    public String getPhone() {
        return phone;
    }

    /**
     * sets patient's phone number
     * @param phone number
     */
    public void setPhone(String phone) {
        if (!Pattern.matches("\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d",phone)){
            throw new IllegalArgumentException("Invalid phone number");
        }
        this.phone = phone;
    }

    /**
     *
     * @return patient's email
     */
    public String getEmail() {
        return email;
    }

    /**
     * sets patient's email
     * @param email patient's email
     */
    public void setEmail(String email) {
        if (!Pattern.matches("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",email))
        this.email = email;
    }

    /**
     *
     * @return patient's Insurance object
     */
    public Insurance getInsurance() {
        return insurance;
    }

    /**
     * sets patient's Insurance object
     * @param insurance Insurance
     */
    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }

    /**
     *
     * @return patient's card number
     */
    public long getCardNumber() {
        return cardNumber;
    }

    /**
     * sets patient's card number
     * @param cardNumber card number
     */
    public void setCardNumber(long cardNumber) {
        if (cardNumber < MIN_CARD_NUMBER || cardNumber > MAX_CARD_NUMBER){
            throw new IllegalArgumentException("invalid card number");
        }
        this.cardNumber = cardNumber;
    }

    /**
     *
     * @return patient's account
     */
    public PatientAccount getAccount() {
        return account;
    }

    /**
     * sets patient's account
     * @param account
     */
    public void setAccount(PatientAccount account) {
        this.account = account;
    }

    /**
     *
     * @return patient's info as a string
     */
    @Override
    public String toString() {
        String ins;
        String card;
        if (insurance == null){
            ins = "None on File";
        } else {
            ins = String.valueOf(this.getInsurance());
        }
        if (cardNumber == 0){
            card = "No";
        } else {
            card = "Yes";
        }
        return super.toString() +
                "\nPhone: " + this.getPhone() + "\n" +
                "Email: " + this.getPhone() + "\n" +
                "Insurance: " + ins + "\n" +
                "Card on file: " + card;
    }
}
