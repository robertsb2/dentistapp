package model.patient;

public class PatientFactory {
    public static Patient getInstance(){
        return new PatientImpl();
    }

    public static Patient getInstance(String firstName, String lastName, int userID, String phone, String email){
        return new PatientImpl(firstName,lastName,userID,phone,email);
    }
}
