package model.reports;

import java.util.ArrayList;

public class ProductionReport extends ArrayList<ProductionReportRecord> {
    private String startDate;
    private String endDate;
    private String grouping;

    public ProductionReport() {
    }

    public ProductionReport(String startDate, String endDate, String grouping) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.grouping = grouping;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getGrouping() {
        return grouping;
    }

    public void setGrouping(String grouping) {
        this.grouping = grouping;
    }
}
