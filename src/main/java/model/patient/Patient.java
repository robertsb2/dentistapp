package model.patient;

import model.Person;
import model.reports.ProcedureImpl;

public interface Patient extends Person {
    public String getPhone();

    public void setPhone(String phone);

    public String getEmail();

    public void setEmail(String email);

    public InsuranceImpl getInsurance();

    public void setInsurance(InsuranceImpl insurance);

    public long getCardNumber();

    public void setCardNumber(long cardNumber);

    public ProcedureImpl[] getProcedures();

    public void setProcedures(ProcedureImpl[] procedures);

    public String toString();

}
