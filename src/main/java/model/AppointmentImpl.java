package model;

import model.patient.Patient;
import model.reports.Procedure;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class AppointmentImpl implements Appointment, Serializable {
    private LocalDateTime date;
    private Patient patient;
    private ArrayList<Procedure> procedures;

    public AppointmentImpl() {
    }

    public AppointmentImpl(LocalDateTime date, Patient patient, Procedure procedure) {
        this.setDate(date);
        this.setPatient(patient);
        this.addProcedure(procedure);
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
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

    public void addProcedure(Procedure procedure) {
        this.procedures.add(procedure);
    }

    @Override
    public String toString() {
        return this.getPatient() + "\n" +
                this.getProcedures() + "\n" +
                "Time: " + this.getDate();
    }
}
