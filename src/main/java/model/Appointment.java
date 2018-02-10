package model;

import model.patient.Patient;
import model.reports.Procedure;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;

public interface Appointment extends Serializable {
    LocalDateTime getDate();

    void setDate(LocalDateTime date);

    Patient getPatient();

    void setPatient(Patient patient);

    ArrayList<Procedure> getProcedures();

    void addProcedure(Procedure procedure);

}
