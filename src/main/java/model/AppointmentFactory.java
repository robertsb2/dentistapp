package model;

public class AppointmentFactory {
    public Appointment getInstance(){
        return new AppointmentImpl();
    }
}
