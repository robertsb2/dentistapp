package model.reports;

public class PatientReportRecord implements Comparable<PatientReportRecord>{
    private String name;
    private double balance;

    public PatientReportRecord() {
    }

    public PatientReportRecord(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Name: " + this.getName() + "\n" +
                "Balance: " + this.getBalance();
    }

    @Override
    public int compareTo(PatientReportRecord o) {
        return Double.compare(this.getBalance(),o.getBalance());
    }
}
