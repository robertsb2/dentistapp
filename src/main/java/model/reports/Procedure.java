package model.reports;

import model.provider.Provider;

import java.io.Serializable;
import java.text.ParseException;
import java.time.LocalDate;

public interface Procedure extends Serializable {
    String getCode();

    void setCode(String code);

    double getCost();

    void setCost(double cost);

    String getDescription();

    void setDescription(String description);

    LocalDate getDateCompleted();

    void setDateCompleted(LocalDate dateCompleted) throws ParseException;

    Provider getProvider();

    void setProvider(Provider provider);

}
