package model.reports;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ProductionReportRecord {
    private LocalDate date;
    private double total;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-YYYY");

    /**
     * default constructor
     */
    public ProductionReportRecord() {
    }

    /**
     * overloaded constructor
     * @param total total production
     * @param date date of the record
     */
    public ProductionReportRecord(double total, LocalDate date) {
        this.setDate(date);
        this.setTotal(total);
    }

    /**
     *
     * @return date of the record
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * sets record date
     * @param date date of the record
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     *
     * @return production total
     */
    public double getTotal() {
        return total;
    }

    /**
     * sets production total
     * @param total production total
     */
    public void setTotal(double total) {
        if (total < 0){
            throw new IllegalArgumentException("total cannot be negative");
        }
        this.total = total;
    }

    /**
     *
     * @return record info as a string
     */
    @Override
    public String toString() {
        return "Date: " + this.getDate().format(formatter) +"\n" +
                "Total: " + this.getTotal();
    }
}
