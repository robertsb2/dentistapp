package model;

import model.patient.Patient;
import model.reports.Procedure;
import java.time.LocalDateTime;

public class AppointmentFactory {
    /**
     * creates instance of a class that implements Appointment
     * @return instance
     */
    public static Appointment getInstance(){
        return new AppointmentImpl();
    }

    /**
     * creates instance of a class that implements Appointment through overloaded constructor
     * @param date appointment date and time
     * @param patient patient for the appointment
     * @param procedure procedures to be performed
     * @return instance
     */
    public static Appointment getInstance(LocalDateTime date, Patient patient, Procedure procedure){
        return new AppointmentImpl(date, patient, procedure);
    }
}
