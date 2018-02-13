package controller;


import model.Appointment;
import model.AppointmentFactory;
import model.patient.*;
import model.provider.Provider;
import model.provider.ProviderFactory;
import model.reports.Procedure;
import model.reports.ProcedureFactory;
import model.user.AdminUser;
import model.user.AdminUserFactory;
import model.user.User;
import model.user.UserFactory;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;


public class TestDriver {
    private static Controller controller = new Controller();
    private static User currentUser;
    private static Provider currentProvider;
    private static Patient currentPatient;
    private static final int LEAST_TO_GREATEST = 1;
    private static final int GREATEST_TO_LEAST = 2;


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        if (controller.start()) {
            currentUser = controller.login("B_Roberts", "Ch33d@rS");
        } else {
            controller.setup();
            currentUser = controller.login("Administrator", "1234Password");
            currentUser.setUsername("B_Roberts");
            currentUser.setFirstName("Bryan");
            currentUser.setLastName("Roberts");
        }
        createData();
        testUserAccess();
        setCurrentProvider();
        setCurrentPatient();
        editInfo();
        searches();
        addPayments();
        getReports();



    }

    private static void addPayments() {
        currentPatient.setInsurance(InsuranceFactory.getInstance("Aetna",431431,5415425));
        currentPatient.setCardNumber(6786678697973453L);

        currentPatient.getAccount().addProcedure(ProcedureFactory.getInstance("D00123",4500,"Tooth Extraction",LocalDate.of(2018,2,7)),4000);
        currentPatient.getAccount().addPayment(new Payment(3800,"Insurance",LocalDate.now()));
    }

    private static void getReports() {
        System.out.println("Collections 2/1/18-2/5/18 day");
        System.out.println(controller.getCollectionsReport(LocalDate.of(2019, 2, 1), LocalDate.of(2019, 2, 5), 1));
        System.out.println("");
        System.out.println("Collections 2/1/18-2/5/18 month");
        System.out.println(controller.getCollectionsReport(LocalDate.of(2019, 2, 1), LocalDate.of(2019, 2, 5), 2));
        System.out.println("");
        System.out.println("Production 2/1/18-2/10/18 day");
        System.out.println(controller.getProductionReport(LocalDate.of(2019, 2, 1), LocalDate.of(2019, 2, 10), 1));
        System.out.println("");
        System.out.println("Production 2/1/18-2/10/18 month");
        System.out.println(controller.getProductionReport(LocalDate.of(2019, 2, 1), LocalDate.of(2019, 2, 10), 2));
        System.out.println("");
        System.out.println("Patients least to greatest");
        System.out.println(controller.getPatientBalanceReport(LEAST_TO_GREATEST));
        System.out.println("");
        System.out.println("Patients greatest to least");
        System.out.println(controller.getPatientBalanceReport(GREATEST_TO_LEAST));
        System.out.println("");

    }

    private static void searches() {
        System.out.println();
        System.out.println("Search user by name");
        System.out.println(controller.searchUser("Cameron"));
        System.out.println("");
        System.out.println("search patient by insurance");
        System.out.println(controller.searchPatient("Blue Cross"));
        System.out.println("");
        System.out.println("search provider by title");
        System.out.println(controller.searchProvider("Dental Assistant"));
        System.out.println("");
        System.out.println("search appointments");
        ArrayList<Appointment> results = controller.searchAppointments(null,LocalDate.of(2019,2,14),currentPatient,currentProvider,"D05432");
        for (Appointment appointment : results){
            System.out.println(appointment.getDate() + ", " + appointment.getPatient().getFirstName() + ", " + appointment.getProcedures().size());
        }
        System.out.println("");

    }

    private static void editInfo() {
        currentPatient.setLastName("Martel");
        currentPatient.setInsurance(InsuranceFactory.getInstance("Blue Cross",10001821,541531515));
        currentProvider.setFirstName("Jane");
        System.out.println("Current Patient");
        System.out.println(currentPatient);
        System.out.println("");
        System.out.println("Current Provider");
        System.out.println(currentProvider);
        System.out.println("");
    }

    private static void setCurrentProvider() {
        currentProvider = controller.getProvider(803);
    }

    private static void setCurrentPatient() {
        currentPatient = controller.getPatient(103);
    }

    private static void testUserAccess() throws IOException {
        currentUser = controller.login("Mc_Roonster23", "Roony4Ever");
        try{
            controller.changePassword(controller.getUser(405),"Admin");
            controller.deleteUser(controller.getUser(402));
        } catch (SecurityException ex){
            System.out.println("Security Success");
            System.out.println("");
        }

        currentUser = controller.login("Apache22", "Raptor22");
        controller.deleteUser(controller.getUser(401));

    }


    private static void createData(){
        User user1 = UserFactory.getInstance("Mickey", "Rooney", 401, "Mc_Roonster23", "Roony4Ever");
        User user2 = UserFactory.getInstance("Kevin", "James", 402, "Mr_FunnyPants", "IamNOTshort5");
        User user3 = UserFactory.getInstance("Levar", "Burton", 403, "ReaderMan", "RR45Lyfe");
        AdminUser user4 = AdminUserFactory.getInstance("Cameron", "Christenson", 404, "Apache22", "Raptor22");
        AdminUser user5 = AdminUserFactory.getInstance("Lawrence", "Welk", 405, "Jazzy", "Elephants2");


        Patient pat1 = PatientFactory.getInstance("Bryan", "Roberts", 101, "208-360-1348", "broberts@student.neumont.edu");
        Patient pat2 = PatientFactory.getInstance("Travis", "Roberts", 102, "208-359-1927", "trob@gmail.com");
        Patient pat3 = PatientFactory.getInstance("Shelby", "Martel", 103, "208-360-1516", "shelby_mr@hotmail.com");
        Patient pat4 = PatientFactory.getInstance("Deb", "Roberts", 104, "208-716-4793", "cd5k@cableone.net");
        Patient pat5 = PatientFactory.getInstance("Cory", "Roberts", 105, "208-390-0643", "cd5k@cableone.net");


        Procedure pro1 = ProcedureFactory.getInstance("D00231",100,"Tooth Extraction",LocalDate.now());
        Procedure pro2 = ProcedureFactory.getInstance("D05432",150,"Retainer Crown",LocalDate.now());
        Procedure pro3 = ProcedureFactory.getInstance("D06441",900,"Root Canal",LocalDate.now());
        Procedure pro4 = ProcedureFactory.getInstance("D00874",50,"Cleaning",LocalDate.now());
        Procedure pro5 = ProcedureFactory.getInstance("D78914",75,"X-ray",LocalDate.now());
        Procedure pro6 = ProcedureFactory.getInstance("D00000",75,"PlaceHolder",LocalDate.now());

        Provider prov1 = ProviderFactory.getInstance("Leo","Marvin",801,"Dentist");
        Provider prov2 = ProviderFactory.getInstance("Martin","Short",802,"Dentist");
        Provider prov3 = ProviderFactory.getInstance("Leonard","Williams",803,"Dental Assistant");
        Provider prov4 = ProviderFactory.getInstance("Margaret","Thatcher",804,"Dental Hygienist");
        Provider prov5 = ProviderFactory.getInstance("Amanda","Lee",805,"Dental Assistant");


        Appointment app1 = AppointmentFactory.getInstance(LocalDate.of(2019,2,13).atTime(12,30),pat3,pro1);
        Appointment app2 = AppointmentFactory.getInstance(LocalDate.of(2019,2,14).atTime(2,15),pat3,pro2);
        Appointment app3 = AppointmentFactory.getInstance(LocalDate.of(2019,2,12).atTime(14,30),pat3,pro2);
        Appointment app4 = AppointmentFactory.getInstance(LocalDate.of(2019,2,13).atTime(11,45),pat3,pro4);
        Appointment app5 = AppointmentFactory.getInstance(LocalDate.of(2019,2,14).atTime(3,15),pat3,pro5);




        pro1.setProvider(prov1);
        pro2.setProvider(prov3);
        pro3.setProvider(prov3);
        pro4.setProvider(prov4);
        pro5.setProvider(prov5);




        pat1.getAccount().addProcedure(pro1,20);
        pat2.getAccount().addProcedure(pro1,20);
        pat3.getAccount().addProcedure(pro1,20);
        pat4.getAccount().addProcedure(pro1,20);
        pat5.getAccount().addProcedure(pro1,20);


        controller.changePassword(currentUser, "Ch33d@rS");

        controller.addUser(user1);
        controller.addUser(user2);
        controller.addUser(user3);
        controller.addUser(user4);
        controller.addUser(user5);

        controller.addProcedure(pro1);
        controller.addProcedure(pro2);
        controller.addProcedure(pro3);
        controller.addProcedure(pro4);
        controller.addProcedure(pro5);
        controller.addProcedure(pro6);
        controller.removeProcedure(pro6);

        controller.addProvider(prov1);
        controller.addProvider(prov2);
        controller.addProvider(prov3);
        controller.addProvider(prov4);
        controller.addProvider(prov5);
//        controller.addProvider(prov6);
//        controller.removeProvider(prov6);

        controller.addPatient(pat1);
        controller.addPatient(pat2);
        controller.addPatient(pat3);
        controller.addPatient(pat4);
        controller.addPatient(pat5);
//        controller.addPatient(pat6);
//        controller.removePatient(pat6);

        controller.addAppointment(app1);
        controller.addAppointment(app2);
        controller.addAppointment(app3);
        controller.addAppointment(app4);
        controller.addAppointment(app5);
//        controller.addAppointment(app6);
//        controller.removeAppointment(app6);

    }

}
