package model.reports;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ProductionReportRecord {
    private LocalDate date;
    private double total;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-YYYY");

    public ProductionReportRecord() {
    }

    public ProductionReportRecord(double total, LocalDate date) {
        this.setDate(date);
        this.setTotal(total);
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

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Date: " + this.getDate().format(formatter) +"\n" +
                "Total: " + this.getTotal();
    }
}
