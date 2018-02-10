package controller;


import model.patient.*;
import model.reports.ProcedureFactory;
import model.user.User;
import model.user.UserFactory;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;


public class TestDriver {
    static Controller controller = new Controller();
    static User currentUser;

    public static void main(String[] args) throws IOException, ClassNotFoundException, ParseException {
        if(controller.start()) {
            currentUser = controller.login("B_Roberts","Ch33d@r");
        } else {
            controller.setup();
            currentUser = controller.login("Administrator", "1234Password");
            currentUser.setUsername("B_Roberts");
            currentUser.setFirstName("Bryan");
            currentUser.setLastName("Roberts");
        }
        User user1 = UserFactory.getInstance("Mickey","Rooney",401,"Mc_Roonster23","Roony4Ever");



        Patient pat1 = PatientFactory.getInstance("Bryan","Roberts", 101,"208-360-1348","broberts@student.neumont.edu");
        Patient pat2 = PatientFactory.getInstance("Travis","Roberts",102,"208-359-1927","trob@gmail.com");
        Patient pat3 = PatientFactory.getInstance("Shelby","Roberts",103,"208-360-1516","shelby_mr@hotmail.com");
        Patient pat4 = PatientFactory.getInstance("Deb","Roberts",104,"208-716-4793","cd5k@cableone.net");
        Patient pat5 = PatientFactory.getInstance("Cory","Roberts",105,"208-390-0643","cd5k@cableone.net");





        controller.changePassword(currentUser,"Ch33d@r");
        controller.logout();
        controller.login("B_Roberts","Ch33d@r");

        controller.addUser();
        controller.deleteUser();
        System.out.println(controller.searchUser("B_Roberts"));

        controller.addPatient();
        controller.removePatient();
        System.out.println(controller.searchPatient("Patient 1"));

        controller.addProvider();
        controller.removeProvider();
        controller.searchProvider();

        controller.addProcedure();
        controller.removeProcedure();

        controller.addAppointment();
        controller.removeAppointment();
        controller.searchAppointments();
        controller.searchAppointments();

        controller.getCollectionsReport(LocalDate.of(2018,2,1),LocalDate.of(2018,2,5),"day");
        controller.getProductionReport(LocalDate.of(2018,2,1),LocalDate.of(2018,2,10),"day");
        controller.getPatientBalanceReport(1);

//        controller.save();

    }

    private static void run() {
        while (controller.isLogin()) {

        }
    }

}
