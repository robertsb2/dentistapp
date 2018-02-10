package model;

import model.patient.Patient;
import model.reports.Procedure;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public interface Appointment extends Serializable {
    LocalDate getDate();

    void setDate(LocalDate date);

    Patient getPatient();

    void setPatient(Patient patient);

    ArrayList<Procedure> getProcedures();

    void setProcedures(ArrayList<Procedure> procedures);

}
