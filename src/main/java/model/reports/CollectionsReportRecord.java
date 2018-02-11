package model.reports;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class CollectionsReportRecord {
    private double total;
    private LocalDate date;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-YYYY");

    /**
     * default constructor
     */
    public CollectionsReportRecord() {
    }

    /**
     * overloaded constructor
     * @param total total amount collected
     * @param date date of record
     */
    public CollectionsReportRecord(double total, LocalDate date) {
        this.setTotal(total);
        this.setDate(date);
    }

    /**
     *
     * @return date of record
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * sets date of record
     * @param date date of record
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     *
     * @return collections total
     */
    public double getTotal() {
        return total;
    }

    /**
     * sets collections total
     * @param cost
     */
    public void setTotal(double cost) {
        this.total = cost;
    }

    /**
     *
     * @return record info as a string
     */
    @Override
    public String toString() {
        return "Date: " + this.getDate().format(formatter) +"\n" +
                "Total: " + this.getTotal() + "\n";
    }
}
