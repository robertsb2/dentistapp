package model.reports;

import java.time.LocalDate;
import java.util.ArrayList;

public class CollectionsReport extends ArrayList<CollectionsReportRecord>{
    private LocalDate startDate;
    private LocalDate endDate;
    private String grouping;

    /**
     * default constructor
     */
    public CollectionsReport() {
    }

    /**
     * overloaded constructor
     * @param startDate start of date range
     * @param endDate end of date range
     * @param grouping record grouping type either day or month
     */
    public CollectionsReport(LocalDate startDate, LocalDate endDate, String grouping) {
        this.setStartDate(startDate);
        this.setEndDate(endDate);
        this.setGrouping(grouping);
    }

    /**
     *
     * @return start date
     */
    public LocalDate getStartDate() {
        return startDate;
    }

    /**
     * sets start date
     * @param sDate start date
     */
    public void setStartDate(LocalDate sDate) {
      this.startDate = sDate;
    }

    /**
     *
     * @return end date
     */
    public LocalDate getEndDate() {
        return endDate;
    }

    /**
     * sets end date
     * @param eDate end date
     */
    public void setEndDate(LocalDate eDate){
        LocalDate temp = eDate;
        temp = LocalDate.of(temp.getYear(),temp.getMonth(),temp.getDayOfMonth() +1);
        this.endDate = temp;
    }

    /**
     *
     * @return grouping type
     */
    public String getGrouping() {
        return grouping;
    }

    /**
     * sets grouping type
     * @param grouping
     */
    public void setGrouping(String grouping) {
        if (!grouping.equalsIgnoreCase("day") &&
                !grouping.equalsIgnoreCase("month")){
            throw new IllegalArgumentException("grouping must be either 'day' or month");
        }
        this.grouping = grouping;
    }


}
