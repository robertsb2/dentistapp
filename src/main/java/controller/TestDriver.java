package controller;


import model.patient.Patient;
import model.patient.PatientAccount;
import model.patient.PatientFactory;
import model.patient.Payment;
import model.user.User;

import java.io.IOException;
import java.text.ParseException;
import java.util.Calendar;

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

        for (int i = 0; i < 5; i++) {
            Calendar test = Calendar.getInstance();
            Patient temp = PatientFactory.getInstance();
            PatientAccount account = new PatientAccount();
            test.set(Calendar.DAY_OF_MONTH, i);
            account.addPayment(new Payment(25 + i,"Patient",test));
            temp.setAccount(account);
            controller.addPatient(temp);
        }



        if (controller.isLogin()){
            controller.changePassword(currentUser,"Ch33d@r");
            System.out.println(currentUser.getUsername());
        }

        controller.getCollectionsReport("2/1/2018","2/5/2018","day");
        controller.save();

    }

    private static void run() {
        while (controller.isLogin()) {

        }
    }

}
