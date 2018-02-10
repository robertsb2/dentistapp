package model.patient;

public class InsuranceFactory {
    public static Insurance getInstance(){
        return new InsuranceImpl();
    }
    public static Insurance getInstance(String company, int groupId, int memberId){
        return new InsuranceImpl(company,groupId,memberId);
    }
}
