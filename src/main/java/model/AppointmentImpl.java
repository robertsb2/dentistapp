package model;

import model.patient.Patient;
import model.reports.Procedure;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class AppointmentImpl implements Appointment, Serializable {
    private LocalDateTime date;
    private Patient patient;
    private ArrayList<Procedure> procedures = new ArrayList<>();

    /**
     * default constructor
     */
    public AppointmentImpl() {
    }

    /**
     * overloaded constructor
     * @param date appointment date and time
     * @param patient patient for the appointment
     * @param procedure procedures to be performed
     */
    public AppointmentImpl(LocalDateTime date, Patient patient, Procedure procedure) {
        this.setDate(date);
        this.setPatient(patient);
        this.addProcedure(procedure);
    }

    /**
     *
     * @return date and time of appointment
     */
    public LocalDateTime getDate() {
        return date;
    }

    /**
     * sets date and time of appointment
     * @param date date and time
     */
    public void setDate(LocalDateTime date) {
        if (date.isBefore(LocalDateTime.now())){
            throw new IllegalArgumentException("date cannot be in the past");
        }
        this.date = date;
    }

    /**
     *
     * @return patient for appointment
     */
    public Patient getPatient() {
        return patient;
    }

    /**
     * sets patient for appointment
     * @param patient patient
     */
    public void setPatient(Patient patient) {
        if (patient == null){
            throw new IllegalArgumentException("patient cannot be null");
        }
        this.patient = patient;
    }

    /**
     *
     * @return procedures to be completed
     */
    public ArrayList<Procedure> getProcedures() {
        return procedures;
    }

    /**
     * adds procedure to the list
     * @param procedure procedure
     */
    public void addProcedure(Procedure procedure) {
        if (procedure == null){
            throw new IllegalArgumentException("procedure cannot be null");
        }
        this.procedures.add(procedure);
    }

    /**
     *
     * @return appointment info as a string
     */
    @Override
    public String toString() {
        return this.getPatient() + "\n" +
                this.getProcedures() + "\n" +
                "Time: " + this.getDate();
    }
}
