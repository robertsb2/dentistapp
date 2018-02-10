package model.patient;

public class InsuranceFactory {
    public static Insurance getinstance(){
        return new InsuranceImpl();
    }
}
