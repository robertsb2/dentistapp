package model.patient;

import java.io.Serializable;
import java.time.LocalDate;

public class Payment implements Serializable{
    private double amount;
    private String source;
    private LocalDate date;

    public Payment() {
        this.setDate(date = LocalDate.now());
    }

    public Payment(double amount, String source, LocalDate date) {
        this.setAmount(amount);
        this.setSource(source);
        this.setDate(date);

    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public LocalDate getDate() {
        return date;
    }

    void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Amount: " + amount + "\n" + this.getDate();
    }
}
