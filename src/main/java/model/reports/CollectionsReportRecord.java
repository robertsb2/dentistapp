package model.reports;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.format.DateTimeFormatter;


public class CollectionsReportRecord {
    private double total;
    private LocalDate date;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-YYYY");

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
        return "Date: " + this.getDate().format(formatter) +"\n" +
                "Total: " + this.getTotal() + "\n";
    }
}
