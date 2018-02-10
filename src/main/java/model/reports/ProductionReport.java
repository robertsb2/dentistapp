package model.reports;

import java.time.LocalDate;
import java.util.ArrayList;

public class ProductionReport extends ArrayList<ProductionReportRecord> {
    private LocalDate startDate;
    private LocalDate endDate;
    private String grouping;

    public ProductionReport() {
    }

    public ProductionReport(LocalDate startDate, LocalDate endDate, String grouping) {
        this.setStartDate(startDate);
        this.setEndDate(endDate);
        this.setGrouping(grouping);
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        LocalDate temp = endDate;
        temp = LocalDate.of(temp.getYear(),temp.getMonth(),temp.getDayOfMonth() +1);
        this.endDate = temp;
    }

    public String getGrouping() {
        return grouping;
    }

    public void setGrouping(String grouping) {
        this.grouping = grouping;
    }

}
