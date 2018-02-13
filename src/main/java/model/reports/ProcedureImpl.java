package model.reports;

import model.provider.Provider;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.regex.Pattern;

public class ProcedureImpl implements Procedure, Serializable{
    private String code;
    private double cost;
    private String description;
    private LocalDate dateCompleted;
    private Provider provider;

    /**
     * default constructor
     */
    public ProcedureImpl() {
        this.setDateCompleted(LocalDate.now());
    }

    /**
     * overloaded constructor
     * @param code Procedure code in the form of D#####
     * @param cost Standard procedure cost
     * @param description Procedure description
     * @param date date Procedure was completed
     */
    public ProcedureImpl(String code, double cost, String description, LocalDate date) {
        this.setCode(code);
        this.setCost(cost);
        this.setDescription(description);
        this.setDateCompleted(date);
    }

    /**
     *
     * @return provider for the procedure
     */
    public Provider getProvider() {
        return provider;
    }

    /**
     * sets provider for the procedure
     * @param provider provider
     */
    public void setProvider(Provider provider) {
        if (provider == null){
            throw new IllegalArgumentException("provider cannot be null");
        }
        this.provider = provider;
    }

    /**
     *
     * @return Procedure code
     */
    public String getCode() {
        return code;
    }

    /**
     * sets Procedure code
     * @param code Procedure code
     */
    public void setCode(String code) {
        if (Pattern.matches("D\\d\\d\\d\\d\\d",code)) {
            this.code = code;
        } else {
            throw new IllegalArgumentException("Code must be match pattern D#####");
        }
    }

    /**
     *
     * @return standard cost
     */
    public double getCost() {
        return cost;
    }

    /**
     * sets standard cost
     * @param cost standard cost
     */
    public void setCost(double cost) {
        if (cost <= 0){
            throw new IllegalArgumentException("cost must be greater than 0");
        }
        this.cost = cost;
    }

    /**
     *
     * @return Procedure description
     */
    public String getDescription() {
        return description;
    }

    /**
     * sets Procedure description
     * @param description Procedure description;
     */
    public void setDescription(String description) {
        if (description.isEmpty()){
            throw new IllegalArgumentException("description cannot be empty");
        }
        this.description = description;
    }

    /**
     *
     * @return date procedure was completed
     */
    public LocalDate getDateCompleted() {
        return dateCompleted;
    }

    /**
     * sets date procedure was completed
     * @param dateCompleted date completed
     */
    public void setDateCompleted(LocalDate dateCompleted){
        if (dateCompleted.isAfter(LocalDate.now().plusDays(1))){
            throw new IllegalArgumentException("Completion date cannot be set for the future");
        }
        this.dateCompleted = dateCompleted;
    }

    /**
     *
     * @return Procedure info as a string
     */
    @Override
    public String toString() {
        return "Procedure Code: " + this.getCode() + "\n" +
                this.getDescription() + "\n" +
                "Standard Cost: " + this.getCost() + "\n" +
                "Provider: " + this.getProvider();
    }
}
