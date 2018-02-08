package model.patient;

import model.PersonImpl;
import model.reports.ProcedureImpl;

public class PatientImpl extends PersonImpl implements Patient {
    private String phone;
    private String email;
    private InsuranceImpl insurance;
    private long cardNumber;
    private ProcedureImpl[] procedures;

    public PatientImpl() {
    }

    public PatientImpl(String firstName, String lastName, int userID, String phone, String email) {
        super(firstName, lastName, userID);
        this.phone = phone;
        this.email = email;
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

    public InsuranceImpl getInsurance() {
        return insurance;
    }

    public void setInsurance(InsuranceImpl insurance) {
        this.insurance = insurance;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public ProcedureImpl[] getProcedures() {
        return procedures;
    }

    public void setProcedures(ProcedureImpl[] procedures) {
        this.procedures = procedures;
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
        return super.toString() + "\n" +
                "Phone: " + this.getPhone() + "\n" +
                "Email: " + this.getPhone() + "\n" +
                "Insurance: " + ins + "\n" +
                "Card on file: " + card;
    }
}
