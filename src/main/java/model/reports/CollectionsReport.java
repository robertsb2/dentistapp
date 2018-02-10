package model.reports;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;

public class CollectionsReport extends ArrayList<CollectionsReportRecord>{
    private LocalDate startDate;
    private LocalDate endDate;
    private String grouping;

    public CollectionsReport() {
    }

    public CollectionsReport(LocalDate startDate, LocalDate endDate, String grouping) {
        this.setStartDate(startDate);
        this.setEndDate(endDate);
        this.setGrouping(grouping);
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate sDate) {
      this.startDate = sDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate eDate){
        LocalDate temp = eDate;
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
