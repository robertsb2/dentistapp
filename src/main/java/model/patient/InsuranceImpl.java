package model.patient;

public class InsuranceImpl implements Insurance {
    private String company;
    private int groupId;
    private int memberId;

    public InsuranceImpl() {
    }

    public InsuranceImpl(String company, int groupId, int memberId) {
        this.company = company;
        this.groupId = groupId;
        this.memberId = memberId;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    @Override
    public String toString() {
        return "\n -Company: " + this.getCompany() + "\n" +
                " -Group Id: " + this.getGroupId() + "\n" +
                " -Member Id: " + this.getMemberId();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || this.getClass() != o.getClass()) return false;
        InsuranceImpl insurance = (InsuranceImpl) o;

        return this.getCompany().equals(insurance.getCompany()) &&
                this.getMemberId() == insurance.getMemberId() &&
                this.getGroupId() == insurance.getGroupId();
    }

}
