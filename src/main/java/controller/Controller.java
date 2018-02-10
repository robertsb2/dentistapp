package controller;



import model.Appointment;
import model.patient.Patient;
import model.patient.Payment;
import model.provider.Provider;
import model.reports.*;
import model.user.AdminUser;
import model.user.AdminUserFactory;
import model.user.User;
import java.io.*;
import java.nio.file.AccessDeniedException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

@SuppressWarnings("FieldCanBeLocal")
public class Controller {

    private String filename = "data.sav";
    private ArrayList data = new ArrayList();
    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<Patient> patients = new ArrayList<>();
    private ArrayList<Provider> providers = new ArrayList<>();
    private ArrayList<Procedure> procedures = new ArrayList<>();
    private ArrayList<Appointment> appointments = new ArrayList<>();
    private final int USER_DATA_INDEX = 0;
    private final int PATIENT_DATA_INDEX = 1;
    private final int PROVIDER_DATA_INDEX = 2;
    private final int PROCEDURE_DATA_INDEX = 3;
    private final int APPOINTMENT_DATA_INDEX = 4;
    private final int LEAST_TO_GREATEST = 1;
    private final int GREATEST_TO_LEAST = 2;
    private boolean login = false;
    private User currentUser;


    public boolean isLogin(){
        return login;
    }

    public boolean start() throws IOException, ClassNotFoundException {
        if(load()){
         return true;
        }
        return false;
    }

    public void setup() throws IOException {
        currentUser = AdminUserFactory.getInstance();
        currentUser.setUsername("Administrator");
        currentUser.setPassword("1234Password");
        users.add(currentUser);
//        save();

    }

    public void save() throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename));
        data.add(users);
        data.add(patients);
        data.add(providers);
        data.add(procedures);
        data.add(appointments);
        out.writeObject(data);
        System.out.println("Save Runs");
    }

    private boolean load() throws IOException, ClassNotFoundException {
        try {

            ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
            data = (ArrayList<Serializable>) in.readObject();
        } catch (EOFException | FileNotFoundException e){
            return false;
        }
        users = (ArrayList<User>) data.get(USER_DATA_INDEX);
        patients = (ArrayList<Patient>) data.get(PATIENT_DATA_INDEX);
        providers = (ArrayList<Provider>) data.get(PROVIDER_DATA_INDEX);
        procedures = (ArrayList<Procedure>) data.get(PROCEDURE_DATA_INDEX);
        appointments = (ArrayList<Appointment>) data.get(APPOINTMENT_DATA_INDEX);

        return true;
    }

    public User login(String username, String password){
        for (User user : users){
            if (user.getUsername().equals(username)){
                if (user.getPassword().equals(password)){
                    currentUser = user;
                    login = true;
                    return currentUser;
                }
            }
        }

        return null;
    }

    public void logout(){
        currentUser = null;
        login = false;
    }







    public void changePassword(User user,String newPass) {
        if(isLogin()) {
            if (currentUser == user || currentUser instanceof AdminUser) {
                user.setPassword(newPass);
            }
        } else {
            throw new SecurityException("User not logged in");
        }
    }

    public void addUser(User user){
        if (isLogin()) {
            users.add(user);
        } else {
            throw new SecurityException("User not logged in");
        }
    }
    public void deleteUser(User user){
        if (isLogin()) {
            if (currentUser == user || currentUser instanceof AdminUser) {
                users.remove(user);
            }
        } else {
            throw new SecurityException("User not logged in");
        }
    }
    public String searchUser(String... search) {
        if (isLogin()) {
            ArrayList<User> results = users;
            Iterator<User> itr;
            String param;
            StringBuilder resultsToString = new StringBuilder();
            for (int i = 0; i < search.length; i++) {
                itr = results.iterator();
                param = search[i];
                while (itr.hasNext()) {
                    User user = itr.next();
                    if (param.equalsIgnoreCase(user.getFirstName())) {
                    } else if (param.equalsIgnoreCase(user.getLastName())) {
                    } else if (param.equalsIgnoreCase(user.getUsername())) {
                    } else {
                        itr.remove();
                    }
                }
            }
            for (User user : results) {
                resultsToString.append(user).append("\n");
            }

            return resultsToString.toString();
        }
        throw new SecurityException("User not logged in");
    }


    public void addProvider(Provider provider){
        if (isLogin()) {
            providers.add(provider);
        } else {
            throw new SecurityException("User not logged in");
        }
    }
    public void removeProvider(Provider provider){
        if (isLogin()) {
            providers.remove(provider);
        } else {
            throw new SecurityException("User not logged in");
        }
    }
    public String searchProvider(String... search){
        if (isLogin()) {
            ArrayList<Provider> results = providers;
            Iterator<Provider> itr;
            String param;
            StringBuilder resultsToString = new StringBuilder();
            for (int i = 0; i < search.length; i++) {
                itr = results.iterator();
                param = search[i];
                while (itr.hasNext()) {
                    Provider provider = itr.next();
                    if (param.equalsIgnoreCase(provider.getFirstName())) {
                    } else if (param.equalsIgnoreCase(provider.getLastName())) {
                    } else if (param.equalsIgnoreCase(provider.getTitle())) {
                    } else {
                        itr.remove();
                    }
                }
            }
            for (Provider provider : results) {
                resultsToString.append(provider).append("\n");
            }

            return resultsToString.toString();
        }
        throw new SecurityException("User not logged in");
    }

    public void addAppointment(Appointment appointment){
        if (isLogin()) {
            appointments.add(appointment);
        } else {
            throw new SecurityException("User not logged in");
        }
    }
    public void removeAppointment(Appointment appointment){
        if (isLogin()) {
            appointments.remove(appointment);
        } else {
            throw new SecurityException("User not logged in");
        }
    }
    public String searchAppointments(String... search){
        if (isLogin()) {
            ArrayList<Appointment> results = appointments;
            Iterator<Appointment> itr;
            String param;
            StringBuilder resultsToString = new StringBuilder();
            for (int i = 0; i < search.length; i++) {
                itr = results.iterator();
                param = search[i];
                while (itr.hasNext()) {
                    Appointment appointment = itr.next();
                    if (param.equalsIgnoreCase(appointment.getPatient().getFirstName())) {
                    } else if (param.equalsIgnoreCase(appointment.getPatient().getLastName())) {
                    } else if (param.equalsIgnoreCase(appointment.getPatient().getInsurance().getCompany())) {
                    } else {
                        itr.remove();
                    }
                }
            }
            for (Appointment appointment : results) {
                resultsToString.append(appointment).append("\n");
            }

            return resultsToString.toString();

        }
        throw new SecurityException("User not logged in");
    }
    public String searchAppointments(Provider provider){
        if (isLogin()) {
            ArrayList<Appointment> results = appointments;
            Iterator<Appointment> itr;
            StringBuilder resultsToString = new StringBuilder();
                itr = results.iterator();
                while (itr.hasNext()) {
                    Appointment appointment = itr.next();
                    for (Procedure procedure : appointment.getProcedures())
                    if (procedure.getProvider().getFirstName().equals(provider.getFirstName())) {
                    } else if (procedure.getProvider().getLastName().equals(provider.getLastName())) {
                    } else if (procedure.getProvider().getTitle().equals(provider.getFirstName())) {
                    } else {
                        itr.remove();
                    }

            }
            for (Appointment appointment : results) {
                resultsToString.append(appointment).append("\n");
            }

            return resultsToString.toString();

        }
        throw new SecurityException("User not logged in");
    }


    public void addPatient(Patient patient){
        if (isLogin()) {
            patients.add(patient);
        } else {
            throw new SecurityException("User not logged in");
        }
    }
    public void removePatient(Patient patient){
        if (isLogin()) {
            patients.remove(patient);
        } else {
            throw new SecurityException("User not logged in");
        }
    }
    public String searchPatient(String... search){
        if (isLogin()) {
            ArrayList<Patient> results = patients;
            Iterator<Patient> itr;
            String param;
            StringBuilder resultsToString = new StringBuilder();
            for (int i = 0; i < search.length; i++) {
                itr = results.iterator();
                param = search[i];
                while (itr.hasNext()) {
                    Patient patient = itr.next();
                    if (param.equalsIgnoreCase(patient.getFirstName())) {
                    } else if (param.equalsIgnoreCase(patient.getLastName())) {
                    } else if (param.equalsIgnoreCase(patient.getInsurance().getCompany())) {
                    } else {
                        itr.remove();
                    }
                }
            }
            for (Patient patient : results) {
                resultsToString.append(patient).append("\n");
            }

            return resultsToString.toString();
        }
        throw new SecurityException("User not logged in");
    }



    public void addProcedure(Procedure procedure){
        if (isLogin()) {
            procedures.add(procedure);
        } else {
            throw new SecurityException("User not logged in");
        }
    }
    public void removeProcedure(Procedure procedure){
        if (isLogin()) {
            procedures.remove(procedure);
        } else {
            throw new SecurityException("User not logged in");
        }
    }



    public CollectionsReport getCollectionsReport(LocalDate start, LocalDate end, String sortType) {
        if (isLogin()) {
            CollectionsReport report = new CollectionsReport(start, end, sortType);
            if (report.getGrouping().equalsIgnoreCase("day")) {
                for (LocalDate date = report.getStartDate(); date.isBefore(report.getEndDate()); date = getValidDay(date)) {
                    double total = 0;
                    for (Patient patient : patients) {
                        for (Payment payment : patient.getAccount().getPaymentList()) {
                            if (date.isEqual(payment.getDate())) {
                                total += payment.getAmount();


                            }
                        }
                    }
                    report.add(new CollectionsReportRecord(total, date));
                }
            }

            if (report.getGrouping().equalsIgnoreCase("month")) {
                for (LocalDate date = report.getStartDate(); date.isBefore(report.getEndDate()); date = getValidMonth(date)) {
                    double total = 0;
                    for (Patient patient : patients) {
                        for (Payment payment : patient.getAccount().getPaymentList()) {
                            if (date.isEqual(payment.getDate())) {
                                total += payment.getAmount();


                            }
                        }
                    }
                    report.add(new CollectionsReportRecord(total, date));
                }
            }
            return report;
        }
        throw new SecurityException("User not logged in");
    }
    public ProductionReport getProductionReport(LocalDate start, LocalDate end, String sortType){
        if (isLogin()) {
            ProductionReport report = new ProductionReport(start, end, sortType);
            if (report.getGrouping().equalsIgnoreCase("day")) {
                for (LocalDate date = report.getStartDate(); date.isBefore(report.getEndDate()); date = getValidDay(date)) {
                    double total = 0;
                    for (Patient patient : patients) {
                        for (Procedure key : patient.getAccount().getProceduresCompleted().keySet()) {
                            if (key.getDateCompleted().isEqual(date)) {
                                total += patient.getAccount().getProceduresCompleted().get(key);


                            }
                        }
                    }
                    report.add(new ProductionReportRecord(total, date));
                }
            }

            if (report.getGrouping().equalsIgnoreCase("month")) {
                for (LocalDate date = report.getStartDate(); date.isBefore(report.getEndDate()); date = getValidMonth(date)) {
                    double total = 0;
                    for (Patient patient : patients) {
                        for (Procedure key : patient.getAccount().getProceduresCompleted().keySet()) {
                            if (date.isEqual(key.getDateCompleted())) {
                                total += patient.getAccount().getProceduresCompleted().get(key);


                            }
                        }
                    }
                    report.add(new ProductionReportRecord(total, date));
                }
            }
            return report;
        }
        throw new SecurityException("User not logged in");
    }
    public PatientReport getPatientBalanceReport(int sorting){
        if (isLogin()) {
            PatientReport report = new PatientReport();
            for (Patient patient : patients) {
                double balance = patient.getAccount().getBalance();
                String name = patient.getFirstName() + " " + patient.getLastName();
                report.add(new PatientReportRecord(name, balance));
            }
            switch (sorting) {
                case LEAST_TO_GREATEST:
                    Collections.sort(report);
                    break;
                case GREATEST_TO_LEAST:
                    Collections.sort(report);
                    Collections.reverse(report);
            }

            return report;
        }
        throw new SecurityException("User not logged in");
    }

    private LocalDate getValidMonth(LocalDate date) {
        LocalDate validMonth = date;
        if (date.getMonth().getValue() < 12){
            validMonth = LocalDate.of(date.getYear(),date.getMonth().getValue() + 1,date.getDayOfMonth());
        }
        return validMonth;
    }
    private LocalDate getValidDay(LocalDate date) {
        LocalDate validDate = date;
        switch (date.getMonth().getValue()){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                if (date.getDayOfMonth() >= 31){
                    validDate = LocalDate.of(date.getYear(),date.getMonth(),date.getDayOfMonth()+1);
                } else {
                    validDate = LocalDate.of(date.getYear(),date.getMonth(),1);
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                if (date.getDayOfMonth() < 30){
                    validDate = LocalDate.of(date.getYear(),date.getMonth(),date.getDayOfMonth()+1);
                } else {
                    validDate = LocalDate.of(date.getYear(),date.getMonth(),1);
                }
                break;
            case 2:
                if (date.getDayOfMonth() < 29 && date.isLeapYear()){
                    validDate = LocalDate.of(date.getYear(),date.getMonth(),date.getDayOfMonth()+1);
                } else if(date.getDayOfMonth() < 28){
                    validDate = LocalDate.of(date.getYear(),date.getMonth(),date.getDayOfMonth() + 1);
                } else {
                    validDate = LocalDate.of(date.getYear(),date.getMonth(),1);
                }
                break;
        }
        return validDate;
    }
}

