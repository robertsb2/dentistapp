package model.patient;

public class PatientFactory {
    public static Patient getInstance(){
        return new PatientImpl();
    }
}
