package model.reports;

import model.reports.Procedure;

public class ProcedureImpl implements Procedure {
    private String code;
    private int cost;
    private String description;

    public ProcedureImpl() {
    }

    public ProcedureImpl(String code, int cost, String description) {
        this.setCode(code);
        this.setCost(cost);
        this.setDescription(description);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Procedure Code: " + this.getCode() + "\n" +
                this.getDescription() + "\n" +
                "Standard Cost: " + this.getCost();
    }
}
