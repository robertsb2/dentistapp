package model;

import model.patient.Patient;
import model.reports.Procedure;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class AppointmentFactory {
    public static Appointment getInstance(){
        return new AppointmentImpl();
    }
    public static Appointment getInstance(LocalDateTime date, Patient patient, Procedure procedures){
        return new AppointmentImpl(date, patient, procedures);
    }
}
