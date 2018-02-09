package controller;



import model.patient.Patient;
import model.patient.Payment;
import model.provider.Provider;
import model.reports.CollectionsReport;
import model.reports.CollectionsReportRecord;
import model.reports.Procedure;
import model.user.AdminUser;
import model.user.AdminUserFactory;
import model.user.User;
import java.io.*;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;

public class Controller {

    private String filename = "data.sav";
    private ArrayList data = new ArrayList();
    private ArrayList<User> users = new ArrayList<User>();
    private ArrayList<Patient> patients = new ArrayList<Patient>();
    private ArrayList<Provider> providers = new ArrayList<Provider>();
    private ArrayList<Procedure> procedures = new ArrayList<Procedure>();
    private int USER_DATA_INDEX = 0;
    private int PATIENT_DATA_INDEX = 1;
    private int PROVIDER_DATA_INDEX = 2;
    private int PROCEDURE_DATA_INDEX = 3;
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
        out.writeObject(data);
        System.out.println("Save Runs");
    }

    private boolean load() throws IOException, ClassNotFoundException {
        try {

            ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
            data = (ArrayList<Serializable>) in.readObject();
        } catch (EOFException e){
            return false;
        } catch (FileNotFoundException e){
            return false;
        }
        users = (ArrayList<User>) data.get(USER_DATA_INDEX);
        patients = (ArrayList<Patient>) data.get(PATIENT_DATA_INDEX);
        providers = (ArrayList<Provider>) data.get(PROVIDER_DATA_INDEX);
        procedures = (ArrayList<Procedure>) data.get(PROCEDURE_DATA_INDEX);

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
        if(currentUser == user || currentUser instanceof AdminUser){
            user.setPassword(newPass);
        }

    }



    public void addUser(User user){
        users.add(user);
    }

    public void deleteUser(User user){
        if(currentUser == user || currentUser instanceof AdminUser){
            users.remove(user);
        }
    }

    public User searchUser(String search){
        for (User user : users){
            if(user.getFirstName().equalsIgnoreCase(search) || user.getLastName().equalsIgnoreCase(search) || user.getUsername().equalsIgnoreCase(search)){
                return user;
            }
        }
        return null;
    }

    public void addProvider(Provider provider){
        providers.add(provider);
    }

    public void removeProvider(Provider provider){
        providers.remove(provider);
    }

    public Provider searchProvider(String search){
        for (Provider provider : providers){
            if (provider.getTitle().equalsIgnoreCase(search) || provider.getFirstName().equalsIgnoreCase(search) || provider.getLastName().equalsIgnoreCase(search)){
                return provider;
            }
        }
        return null;
    }

    public void addPatient(Patient patient){
        patients.add(patient);
    }

    public void removePatient(Patient patient){
        patients.remove(patient);
    }

    public ArrayList<Patient> searchPatient(String search){
        ArrayList<Patient> results = new ArrayList<Patient>();
        for (Patient patient : patients){
            if(patient.getFirstName().equalsIgnoreCase(search) || patient.getLastName().equalsIgnoreCase(search) || patient.getInsurance().getCompany().equalsIgnoreCase(search)){
                results.add(patient);
            }
        }
        return results;
    }


    public void addProcedure(Procedure procedure){
        procedures.add(procedure);
    }

    public void removeProcedure(Procedure procedure){
        procedures.remove(procedure);
    }

    public CollectionsReport getCollectionsReport(String start, String end, String sortType) throws ParseException {
        CollectionsReport report = new CollectionsReport(start,end,sortType);
        if (report.getGrouping().equalsIgnoreCase("day")) {
            for (LocalDate date = report.getStartDate(); date.isBefore(report.getEndDate()); date = getValidDate(date)) {
                System.out.println("Date: " + date);
                double total = 0;
                for (Patient patient : patients) {
                    System.out.println(patient + "\n");
                    for (Payment payment : patient.getAccount().getPaymentList()) {
                        System.out.println(payment + "\n");
                        if (date.isEqual(payment.getDate())) {
                            System.out.println("Running");
                            total += payment.getAmount();


                        }
                    }
                }
                report.add(new CollectionsReportRecord(total,date));
            }
        }
        for (CollectionsReportRecord record : report){
            System.out.println(record);
        }
        return report;
    }


    public LocalDate getValidDate(LocalDate date) {
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

