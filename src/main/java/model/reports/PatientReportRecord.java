package model.reports;

import model.patient.Patient;

public class PatientReportRecord implements Comparable<PatientReportRecord>{
    private String name;
    private double balance;

    /**
     * default constructor
     */
    public PatientReportRecord() {
    }

    /**
     * overloaded constructor
     * @param patient the patient
     * @param balance patient's balance
     */
    public PatientReportRecord(Patient patient, double balance) {
        this.setName(patient);
        this.setBalance(balance);
    }

    /**
     *
     * @return patients name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param patient the patient
     */
    public void setName(Patient patient) {
        if (patient ==  null){
            throw new IllegalArgumentException("patient cannot be null");
        }
        if (patient.getFirstName().isEmpty() || patient.getLastName().isEmpty()){
            throw new IllegalArgumentException("patient name is empty");
        }
        this.name = patient.getFirstName() + " " + patient.getLastName();
    }

    /**
     *
     * @return patient's outstanding balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * sets balance of the record
     * @param balance outstanding balance
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     *
     * @return record info as a string
     */
    @Override
    public String toString() {
        return "Name: " + this.getName() + "\n" +
                "Balance: " + this.getBalance();
    }

    /**
     * compares records based on balance
     * @param o second report
     * @return boolean based on results
     */
    @Override
    public int compareTo(PatientReportRecord o) {
        return Double.compare(this.getBalance(),o.getBalance());
    }
}
