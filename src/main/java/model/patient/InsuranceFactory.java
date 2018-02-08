package model.patient;

public class InsuranceFactory {
    public static Insurance getINstance(){
        return new InsuranceImpl();
    }
}
