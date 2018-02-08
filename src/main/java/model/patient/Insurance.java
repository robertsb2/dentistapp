package model.patient;

public interface Insurance {

    String getCompany();

    void setCompany(String company);

    int getGroupId();

    void setGroupId(int groupId);

    int getMemberId();

    void setMemberId(int memberId);

    @Override
    String toString();

    @Override
    boolean equals(Object o);

}
