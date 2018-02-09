package model.reports;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class CollectionsReport extends ArrayList<CollectionsReportRecord>{
    private Calendar startCal = Calendar.getInstance();
    private Calendar endCal = Calendar.getInstance();
    private String grouping;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("mm/dd/yyyy");

    public CollectionsReport() {
    }

    public CollectionsReport(String startDate, String endDate, String grouping) throws ParseException {
        this.setStartDate(startDate);
        this.setEndDate(endDate);
        this.setGrouping(grouping);
    }

    public Calendar getStartDate() {
        return startCal;
    }

    public void setStartDate(String sDate) throws ParseException {
      this.startCal = format(sDate);
    }

    public Calendar getEndDate() {
        return endCal;
    }

    public void setEndDate(String eDate) throws ParseException {
        this.endCal =  format(eDate);
    }

    public String getGrouping() {
        return grouping;
    }

    public void setGrouping(String grouping) {
        this.grouping = grouping;
    }

    private Calendar format(String date){
        Calendar temp = Calendar.getInstance();
        String[] raw = date.split("/");
        int day = Integer.parseInt(raw[0]);
        int month = Integer.parseInt(raw[1]);
        int year = Integer.parseInt(raw[2]);
        temp.set(Calendar.DAY_OF_MONTH,day);
        temp.set(Calendar.MONTH,month);
        temp.set(Calendar.YEAR,year);
        return temp;
    }

}
