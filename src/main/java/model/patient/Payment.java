package model.patient;

import java.io.Serializable;
import java.time.LocalDate;

public class Payment implements Serializable{
    private double amount;
    private String source;
    private LocalDate date;

    /**
     * default constructor
     */
    public Payment() {
        this.setDate(date = LocalDate.now());
    }

    /**
     * overloaded constructor
     * @param amount payment amount
     * @param source payment source either patient or insurance
     * @param date date of payment
     */
    public Payment(double amount, String source, LocalDate date) {
        this.setAmount(amount);
        this.setSource(source);
        this.setDate(date);

    }

    /**
     *
     * @return payment amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * sets payment amount
     * @param amount payment amount
     */
    public void setAmount(double amount) {
        if (amount <= 0){
            throw new IllegalArgumentException("payment must be greater than 0");
        }
        this.amount = amount;
    }

    /**
     *
     * @return payment source
     */
    public String getSource() {
        return source;
    }

    /**
     * sets payment source
     * @param source
     */
    public void setSource(String source) {
        if (!source.equalsIgnoreCase("patient") && !source.equalsIgnoreCase("insurance")){
            throw new IllegalArgumentException("invalid source type");
        }
        this.source = source;
    }

    /**
     * payment date
     * @return
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * sets payment date
     * @param date payment date
     */
    void setDate(LocalDate date) {
        if (date.isAfter(LocalDate.now())){
            throw new IllegalArgumentException("payment date can't be set in the future");
        }
        this.date = date;
    }

    /**
     *
     * @return payment info as a string
     */
    @Override
    public String toString() {
        return "Amount: " + amount + "\n" + this.getDate();
    }
}
