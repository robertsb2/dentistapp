package model.reports;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;

public class CollectionsReport extends ArrayList<CollectionsReportRecord>{
    private LocalDate startCal;
    private LocalDate endCal;
    private String grouping;

    public CollectionsReport() {
    }

    public CollectionsReport(String startDate, String endDate, String grouping) throws ParseException {
        this.setStartDate(startDate);
        this.setEndDate(endDate);
        this.setGrouping(grouping);
    }

    public LocalDate getStartDate() {
        return startCal;
    }

    public void setStartDate(String sDate) throws ParseException {
      this.startCal = format(sDate);
    }

    public LocalDate getEndDate() {
        return endCal;
    }

    public void setEndDate(String eDate) throws ParseException {
        LocalDate temp = format(eDate);
        temp = LocalDate.of(temp.getYear(),temp.getMonth(),temp.getDayOfMonth() +1);
        this.endCal = temp;
    }

    public String getGrouping() {
        return grouping;
    }

    public void setGrouping(String grouping) {
        this.grouping = grouping;
    }

    private LocalDate format(String date){
        String[] raw = date.split("/");
        int month = Integer.parseInt(raw[0]);
        int day = Integer.parseInt(raw[1]);
        int year = Integer.parseInt(raw[2]);
        LocalDate temp = LocalDate.of(year,month,day);
        return temp;
    }

}
