package model.patient;

public class InsuranceFactory {
    /**
     * creates instance of class that implement Insurance
     * @return instance
     */
    public static Insurance getInstance(){
        return new InsuranceImpl();
    }

    /**
     ** creates instance of class that implement Insurance through overloaded constructor
     * @param company the insurance company name
     * @param groupId the patients insurance group id
     * @param memberId the patients insurance member id
     * @return instance of Insurance with parameters
     */
    public static Insurance getInstance(String company, int groupId, int memberId){
        return new InsuranceImpl(company,groupId,memberId);
    }
}
