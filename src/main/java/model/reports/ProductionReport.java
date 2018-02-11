package model.reports;

import java.time.LocalDate;
import java.util.ArrayList;

public class ProductionReport extends ArrayList<ProductionReportRecord> {
    private LocalDate startDate;
    private LocalDate endDate;
    private String grouping;

    /**
     * default constructor
     */
    public ProductionReport() {
    }

    /**
     * overloaded constructor
     * @param startDate start of report range
     * @param endDate end of report range
     * @param grouping grouping type either day or month
     */
    public ProductionReport(LocalDate startDate, LocalDate endDate, String grouping) {
        this.setStartDate(startDate);
        this.setEndDate(endDate);
        this.setGrouping(grouping);
    }

    /**
     *
     * @return start of report range
     */
    public LocalDate getStartDate() {
        return startDate;
    }

    /**
     * sets start of report range
     * @param startDate start date
     */
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    /**
     *
     * @return end of report range
     */
    public LocalDate getEndDate() {
        return endDate;
    }

    /**
     * sets end of report range
     * @param endDate end date
     */
    public void setEndDate(LocalDate endDate) {
        LocalDate temp = endDate;
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
     * @param grouping grouping type either day or month
     */
    public void setGrouping(String grouping) {
        if (!grouping.equalsIgnoreCase("day") &&
                !grouping.equalsIgnoreCase("month")){
            throw new IllegalArgumentException("grouping must be either 'day' or 'month'");
        }
        this.grouping = grouping;
    }

}
