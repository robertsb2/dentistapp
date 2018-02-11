package model.patient;



public class InsuranceImpl implements Insurance {
    private String company;
    private int groupId;
    private int memberId;

    /**
     * default constructor
     */
    public InsuranceImpl() {
    }

    /**
     * overloaded constructor
     * @param company the insurance company name
     * @param groupId the patients insurance group id
     * @param memberId the patients insurance member id
     */
    public InsuranceImpl(String company, int groupId, int memberId) {
        this.setCompany(company);
        this.setGroupId(groupId);
        this.setMemberId(memberId);
    }

    /**
     *
     * @return company name
     */
    public String getCompany() {
        return company;
    }

    /**
     *
     * @param company the insurance company name
     */
    public void setCompany(String company) {
        if(company == null){
            throw new IllegalArgumentException("Company name cannot be null");
        }
        this.company = company;
    }

    /**
     *
     * @return groupId
     */
    public int getGroupId() {
        return groupId;
    }

    /**
     *
     * @param groupId the patients insurance group id
     */
    public void setGroupId(int groupId) {
        if(groupId == 0){
            throw new IllegalArgumentException("group id cannot be 0");
        }
        this.groupId = groupId;
    }

    /**
     *
     * @return memberId
     */
    public int getMemberId() {
        return memberId;
    }

    /**
     *
     * @param memberId the patients insurance member id
     */
    public void setMemberId(int memberId) {
        if (memberId == 0){
            throw new IllegalArgumentException("member id cannot be 0");
        }
        this.memberId = memberId;
    }

    /**
     *
     * @return Insurance info as a string
     */
    @Override
    public String toString() {
        return "\n -Company: " + this.getCompany() + "\n" +
                " -Group Id: " + this.getGroupId() + "\n" +
                " -Member Id: " + this.getMemberId();
    }

    /**
     * compares two insurance policies for equality
     * @param o the second policy
     * @return true or false
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || this.getClass() != o.getClass()) return false;
        InsuranceImpl insurance = (InsuranceImpl) o;

        return this.getCompany().equals(insurance.getCompany()) &&
                this.getMemberId() == insurance.getMemberId() &&
                this.getGroupId() == insurance.getGroupId();
    }

}
