package model.patient;

import model.PersonImpl;


public class PatientImpl extends PersonImpl implements Patient {
    private String phone;
    private String email;
    private Insurance insurance;
    private long cardNumber;
    private PatientAccount account;

    public PatientImpl() {
        this.setAccount(new PatientAccount());
    }

    public PatientImpl(String firstName, String lastName, int userID, String phone, String email) {
        super(firstName, lastName, userID);
        this.setPhone(phone);
        this.setEmail(email);
        this.setAccount(new PatientAccount());
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Insurance getInsurance() {
        return insurance;
    }

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public PatientAccount getAccount() {
        return account;
    }

    public void setAccount(PatientAccount account) {
        this.account = account;
    }

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
