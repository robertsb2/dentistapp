package model;

import model.patient.Patient;
import model.reports.Procedure;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class AppointmentImpl implements Appointment, Serializable {
    private LocalDate date;
    private Patient patient;
    private ArrayList<Procedure> procedures;

    public AppointmentImpl() {
    }

    public AppointmentImpl(LocalDate date, Patient patient, ArrayList<Procedure> procedures) {
        this.setDate(date);
        this.setPatient(patient);
        this.setProcedures(procedures);
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public ArrayList<Procedure> getProcedures() {
        return procedures;
    }

    public void setProcedures(ArrayList<Procedure> procedures) {
        this.procedures = procedures;
    }

    @Override
    public String toString() {
        return this.getPatient() + "\n" +
                this.getProcedures() + "\n" +
                "Time: " + this.getDate();
    }
}
