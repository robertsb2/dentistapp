package model.patient;

import java.io.Serializable;

public interface Insurance extends Serializable{

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
