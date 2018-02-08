package model.reports;

import java.util.Date;

public class CollectionsReportRecord {
    private Date date;
    private int total;

    public CollectionsReportRecord() {
    }

    public CollectionsReportRecord(Date date, Procedure procedure, int cost) {
        this.setDate(date);
        this.setTotal(cost);
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int cost) {
        this.total = cost;
    }

    @Override
    public String toString() {
        return "Actual Charge: " + this.getTotal() + "\n" +
                this.getDate();
    }
}
