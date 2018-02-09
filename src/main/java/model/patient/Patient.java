package model.patient;

import model.Person;

import java.io.Serializable;

public interface Patient extends Person {
    String getPhone();

    void setPhone(String phone);

    String getEmail();

    void setEmail(String email);

    InsuranceImpl getInsurance();

    void setInsurance(InsuranceImpl insurance);

    long getCardNumber();

    void setCardNumber(long cardNumber);

    PatientAccount getAccount();

    void setAccount(PatientAccount account);


    String toString();

}
