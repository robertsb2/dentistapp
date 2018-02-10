package model.patient;

import model.Person;

public interface Patient extends Person {
    String getPhone();

    void setPhone(String phone);

    String getEmail();

    void setEmail(String email);

    Insurance getInsurance();

    void setInsurance(Insurance insurance);

    long getCardNumber();

    void setCardNumber(long cardNumber);

    PatientAccount getAccount();

    void setAccount(PatientAccount account);


    String toString();

}
