package model.reports;

import java.util.Calendar;


public class CollectionsReportRecord {
    private double total;
    private Calendar date;

    public CollectionsReportRecord() {
    }

    public CollectionsReportRecord(double total, Calendar date) {
        this.setTotal(total);
        this.setDate(date);
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
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
