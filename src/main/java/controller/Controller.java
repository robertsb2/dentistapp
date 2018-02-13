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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

@SuppressWarnings({"FieldCanBeLocal", "WeakerAccess", "UnusedReturnValue"})
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
    private final int CHOICE_ONE = 1;
    private final int CHOICE_TWO = 2;
    private boolean login = false;
    private User currentUser;


    private boolean isLogin(){
        return login;
    }

    /**
     * starts the controller and calls load method
     * @return true if controller starts successfully
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public boolean start() throws IOException, ClassNotFoundException {
        return load();
    }

    /**
     * creates initial user and save file
     * @throws IOException
     */
    public void setup() throws IOException {
        currentUser = AdminUserFactory.getInstance();
        currentUser.setUsername("Administrator");
        currentUser.setPassword("1234Password");
        currentUser.setUserID(1);
        users.add(currentUser);
        save();

    }

    /**
     * saves program data
     * @throws IOException
     */
    public void save() throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename));
        data.add(users);
        data.add(patients);
        data.add(providers);
        data.add(procedures);
        data.add(appointments);
        out.writeObject(data);
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

    /**
     * logs user into controller
     * @param username username to verify
     * @param password password to verify
     * @return matching user if username and password are correct
     */
    public User login(String username, String password) throws IOException {
        if(!isLogin()) {
            for (User user : users) {
                if (user.getUsername().equals(username)) {
                    if (user.getPassword().equals(password)) {
                        currentUser = user;
                        login = true;
                        return currentUser;
                    }
                }
            }
            throw new NullPointerException("user not found");
        } else {
            logout();
            login(username,password);
        }

        return null;
    }

    /**
     * logs user out of controller
     */
    public void logout() throws IOException {
        save();
        currentUser = null;
        login = false;
    }

    /**
     * handles change password requests
     * @param user user whose password is to be changed
     * @param newPass new password
     */
    public void changePassword(User user,String newPass) {
        if(isLogin()) {
            if (currentUser == user || currentUser instanceof AdminUser) {
                user.setPassword(newPass);
            }
        } else {
            throw new SecurityException("User not logged in");
        }
    }

    /**
     * adds user to database
     * @param user User
     */
    public void addUser(User user){
        if (isLogin()) {
            if (currentUser instanceof AdminUser) {
                users.add(user);
            } else {
                throw new SecurityException("Restricted Access");
            }
        } else {
            throw new SecurityException("User not logged in");
        }
    }

    /**
     * deletes user from database
     * @param user User
     */
    public void deleteUser(User user){
        if (isLogin()) {
            if (currentUser instanceof AdminUser) {
                users.remove(user);
            } else {
                throw new SecurityException("Restricted Access");
            }
        } else {
            throw new SecurityException("User not logged in");
        }
    }

    /**
     * searches database for a user
     * @param search search parameter(s)
     * @return ArrayList matching users
     */
    public ArrayList<User> searchUser(String... search) {
        if (isLogin()) {
            ArrayList<User> results = (ArrayList<User>) users.clone();
            Iterator<User> itr;
            String param;
            for (String aSearch : search) {
                itr = results.iterator();
                param = aSearch;
                while (itr.hasNext()) {
                    User user = itr.next();
                    if (param.equalsIgnoreCase(user.getFirstName())) {
                        continue;
                    } else if (param.equalsIgnoreCase(user.getLastName())) {
                        continue;
                    } else if (param.equalsIgnoreCase(user.getUsername())) {
                        continue;
                    } else {
                        itr.remove();
                    }
                }
            }
            return results;
        }
        throw new SecurityException("User not logged in");
    }

    /**
     *
     * @return ArrayList of all users
     */
    public ArrayList<User> getUsers() {
        return users;
    }

    /**
     * adds Provider to database
     * @param provider provider
     */
    public void addProvider(Provider provider){
        if (isLogin()) {
            providers.add(provider);
        } else {
            throw new SecurityException("User not logged in");
        }
    }

    /**
     * deletes Provider from database
     * @param provider provider
     */
    public void removeProvider(Provider provider){
        if (isLogin()) {
            providers.remove(provider);
        } else {
            throw new SecurityException("User not logged in");
        }
    }

    /**
     * searches database for provider
     * @param search search parameter(s)
     * @return ArrayList of matching providers
     */
    public ArrayList<Provider> searchProvider(String... search){
        if (isLogin()) {
            ArrayList<Provider> results = (ArrayList<Provider>) providers.clone();
            Iterator<Provider> itr;
            String param;
            for (String aSearch : search) {
                itr = results.iterator();
                param = aSearch;
                while (itr.hasNext()) {
                    Provider provider = itr.next();
                    if (param.equalsIgnoreCase(provider.getFirstName())) {
                        break;
                    } else if (param.equalsIgnoreCase(provider.getLastName())) {
                        continue;
                    } else if (param.equalsIgnoreCase(provider.getTitle())) {
                        continue;
                    } else {
                        itr.remove();
                    }
                }
            }
            return results;
        }
        throw new SecurityException("User not logged in");
    }

    /**
     *
     * @return ArrayList of all Providers
     */
    public ArrayList<Provider> getProviders() {
        return providers;
    }

    /**
     * add Appointment to database
     * @param appointment Appointment
     */
    public void addAppointment(Appointment appointment){
        if (isLogin()) {
            appointments.add(appointment);
        } else {
            throw new SecurityException("User not logged in");
        }
    }

    /**
     * deletes appointment from database
     * @param appointment appointment
     */
    public void removeAppointment(Appointment appointment){
        if (isLogin()) {
            appointments.remove(appointment);
        } else {
            throw new SecurityException("User not logged in");
        }
    }

    /**
     * searches database for matching appointments
     * @param start start date
     * @param end end date
     * @param patient patient
     * @param provider provider
     * @param code procedure code
     * @return
     */
    public ArrayList<Appointment> searchAppointments(LocalDate start, LocalDate end, Patient patient, Provider provider, String code) {
        if (isLogin()) {
            ArrayList<Appointment> results = (ArrayList<Appointment>) appointments.clone();
            for (Appointment appointment : appointments){
                if (start != null && appointment.getDate().isBefore(start.atStartOfDay())){
                    results.remove(appointment);
                } else if (end != null && appointment.getDate().isAfter(end.plusDays(1).atStartOfDay())){
                    results.remove(appointment);
                } else if (patient != null && appointment.getPatient() != patient){
                    results.remove(appointment);
                } else if (provider != null){
                    int i = 0;
                    for (Procedure procedure : appointment.getProcedures()){
                        if (provider != procedure.getProvider()){
                            i++;
                        }
                    }
                    if (i == appointment.getProcedures().size()){
                        results.remove(appointment);
                    }
                } else if (code != null){
                    int i = 0;
                    for (Procedure procedure : appointment.getProcedures()){
                        if (!code.equalsIgnoreCase(procedure.getCode())){
                            i++;
                        }
                    }
                    if (i == appointment.getProcedures().size()){
                        results.remove(appointment);
                    }
                }
            }
            return results;
        }
        throw new SecurityException("User not logged in");

    }

    /**
     *
     * @return ArrayList of all appointments
     */
    public ArrayList<Appointment> getAppointments() {
        return appointments;
    }

    /**
     * add Patient to database
     * @param patient patient
     */
    public void addPatient(Patient patient){
        if (isLogin()) {
            patients.add(patient);
        } else {
            throw new SecurityException("User not logged in");
        }
    }

    /**
     * deletes patient from database
     * @param patient patient
     */
    public void removePatient(Patient patient){
        if (isLogin()) {
            patients.remove(patient);
        } else {
            throw new SecurityException("User not logged in");
        }
    }

    /**
     * searches database for patients
     * @param search search parameter(s)
     * @return ArrayList of matching Patients
     */
    public ArrayList<Patient> searchPatient(String... search){
        if (isLogin()) {
            ArrayList<Patient> results = (ArrayList<Patient>) patients.clone();
            Iterator<Patient> itr;
            String param;
            for (String aSearch : search) {
                itr = results.iterator();
                param = aSearch;
                while (itr.hasNext()) {
                    Patient patient = itr.next();
                    if (param.equalsIgnoreCase(patient.getFirstName())) {
                        continue;
                    } else if (param.equalsIgnoreCase(patient.getLastName())) {
                        continue;
                    } else if (param.equalsIgnoreCase(patient.getInsurance().getCompany())) {
                        continue;
                    } else {
                        itr.remove();
                    }
                }
            }
            return results;
        }
        throw new SecurityException("User not logged in");
    }

    /**
     *
     * @return ArrayList of all patients
     */
    public ArrayList<Patient> getPatients() {
        return patients;
    }

    /**
     * adds procedure to the database
     * @param procedure procedure
     */
    public void addProcedure(Procedure procedure){
        if (isLogin()) {
            procedures.add(procedure);
        } else {
            throw new SecurityException("User not logged in");
        }
    }

    /**
     * deletes procedure from database
     * @param procedure
     */
    public void removeProcedure(Procedure procedure){
        if (isLogin()) {
            procedures.remove(procedure);
        } else {
            throw new SecurityException("User not logged in");
        }
    }

    /**
     *
     * @return ArrayList of all procedures
     */
    public ArrayList<Procedure> getProcedures() {
        return procedures;
    }

    /**
     * generates report of all payments collected
     * @param start start date of report range
     * @param end end date of report range
     * @param sortType report summary type either day or month
     * @return report of all payments
     */
    public CollectionsReport getCollectionsReport(LocalDate start, LocalDate end, int sortType) {
        if (isLogin()) {
            String grouping;
            if (sortType == CHOICE_ONE){
                grouping = "day";
            } else {
                grouping = "month";
            }
            CollectionsReport report = new CollectionsReport(start, end, grouping);
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

    /**
     * generates report of revenue produced
     * @param start start date of report range
     * @param end end date of report range
     * @param sortType report summary type either day or month
     * @return report of production values
     */
    public ProductionReport getProductionReport(LocalDate start, LocalDate end, int sortType){
        if (isLogin()) {
            String grouping;
            if (sortType == CHOICE_ONE){
                grouping = "day";
            } else {
                grouping = "month";
            }
            ProductionReport report = new ProductionReport(start, end, grouping);
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
                            if (key.getDateCompleted().getMonth() == date.getMonth() &&
                                    key.getDateCompleted().isBefore(report.getEndDate()) &&
                                    key.getDateCompleted().isAfter(report.getStartDate())) {
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

    /**
     * generates report of all patient balances
     * @param sorting integer representing sort type: 0: least to greatest or 1: from greatest to least
     * @return report of patient balances
     */
    public PatientReport getPatientBalanceReport(int sorting){
        if (isLogin()) {
            PatientReport report = new PatientReport();
            for (Patient patient : patients) {
                double balance = patient.getAccount().getBalance();
                report.add(new PatientReportRecord(patient, balance));
            }
            switch (sorting) {
                case CHOICE_ONE:
                    Collections.sort(report);
                    break;
                case CHOICE_TWO:
                    Collections.sort(report);
                    Collections.reverse(report);
            }

            return report;
        }
        throw new SecurityException("User not logged in");
    }

    /**
     *
     * @param id unique user id
     * @return provider
     */
    public Provider getProvider(int id) {
        for (Provider provider : providers){
            if (provider.getUserID() == id){
                return provider;
            }
        }
        throw new NullPointerException("Provider not found");
    }

    /**
     *
     * @param id unique user id
     * @return patient
     */
    public Patient getPatient(int id) {
        for (Patient patient : patients){
            if (patient.getUserID() == id){
                return patient;
            }
        }
        throw new NullPointerException("Patient not found");
    }

    public Procedure getProcedure(String code){
        for (Procedure procedure : procedures){
            if (procedure.getCode().equalsIgnoreCase(code)){
                return procedure;
            }
        }
        throw new  NullPointerException("Procedure not found");
    }

    /**
     *
     * @param localDateTime date and time of appointment
     * @return appointment
     */
    public Appointment getAppointment(LocalDateTime localDateTime) {
        for (Appointment appointment : appointments){
            if (appointment.getDate().isEqual(localDateTime)){
                return appointment;

            }
        }
        throw new NullPointerException("Appointment not found");
    }

    /**
     *
     * @param id unique user id
     * @return user
     */
    public User getUser(int id) {
        if(this.currentUser instanceof AdminUser) {
            for (User user : users) {
                if (user.getUserID() == id) {
                    return user;
                }
            }
        } else {
            throw new SecurityException("Access Restricted");
        }
        throw new NullPointerException("user not found");
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

