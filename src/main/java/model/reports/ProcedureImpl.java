package model.reports;

import model.provider.Provider;

import java.io.Serializable;
import java.time.LocalDate;

public class ProcedureImpl implements Procedure, Serializable{
    private String code;
    private double cost;
    private String description;
    private LocalDate dateCompleted;
    private Provider provider;

    public ProcedureImpl() {
        this.setDateCompleted(LocalDate.now());
    }

    public ProcedureImpl(String code, double cost, String description, LocalDate date) {
        this.setCode(code);
        this.setCost(cost);
        this.setDescription(description);
        this.setDateCompleted(date);
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDateCompleted() {
        return dateCompleted;
    }

    public void setDateCompleted(LocalDate dateCompleted){
        this.dateCompleted = dateCompleted;
    }

    @Override
    public String toString() {
        return "Procedure Code: " + this.getCode() + "\n" +
                this.getDescription() + "\n" +
                "Standard Cost: " + this.getCost();
    }
}
