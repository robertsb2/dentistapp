package model.reports;

import java.util.Date;

public class ProductionReportRecord {
    private Date date;
    private Procedure procedure;
    private int cost;

    public ProductionReportRecord() {
    }

    public ProductionReportRecord(Date date, Procedure procedure, int cost) {
        this.setDate(date);
        this.setProcedure(procedure);
        this.setCost(cost);
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Procedure getProcedure() {
        return procedure;
    }

    public void setProcedure(Procedure procedure) {
        this.procedure = procedure;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return this.getProcedure().toString() + "\n" +
                "Actual Charge: " + this.getCost() + "\n" +
                this.getDate();
    }
}
