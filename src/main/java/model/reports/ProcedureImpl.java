package model.reports;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProcedureImpl implements Procedure, Serializable{
    private String code;
    private int cost;
    private String description;
    private Date dateCompleted;

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

    public Date getDateCompleted() {
        return dateCompleted;
    }

    public void setDateCompleted(String dateCompleted) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("mm/dd/yyyy");
        this.dateCompleted = dateFormat.parse(dateCompleted);
    }

    @Override
    public String toString() {
        return "Procedure Code: " + this.getCode() + "\n" +
                this.getDescription() + "\n" +
                "Standard Cost: " + this.getCost();
    }
}
