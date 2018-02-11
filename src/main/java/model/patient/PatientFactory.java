package model.patient;

public class PatientFactory {
    /**
     * creates instance of class that implements Patient
     * @return instance
     */
    public static Patient getInstance(){
        return new PatientImpl();
    }

    /**
     * creates instance of class that implements Patient through overloaded constructor
     * @param firstName patient's first name
     * @param lastName patient's last name
     * @param userID patient's unique id number
     * @param phone patient's phone number
     * @param email patient's email
     * @return instance
     */
    public static Patient getInstance(String firstName, String lastName, int userID, String phone, String email){
        return new PatientImpl(firstName,lastName,userID,phone,email);
    }
}
