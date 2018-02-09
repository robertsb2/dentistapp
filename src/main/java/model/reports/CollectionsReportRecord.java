package model.reports;

import java.time.LocalDate;


public class CollectionsReportRecord {
    private double total;
    private LocalDate date;

    public CollectionsReportRecord() {
    }

    public CollectionsReportRecord(double total, LocalDate date) {
        this.setTotal(total);
        this.setDate(date);
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double cost) {
        this.total = cost;
    }

    @Override
    public String toString() {
        return "Date: " + this.getDate() +"\n" +
                "Total: " + this.getTotal() + "\n";
    }
}
