package model.patient;

import model.reports.Procedure;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class PatientAccount implements Serializable {
    private HashMap<Procedure,Double> proceduresCompleted = new HashMap<Procedure, Double>();
    private ArrayList<Payment> paymentList = new ArrayList<Payment>();
    private double balance;

    public PatientAccount() {
    }

    public PatientAccount(double balance) {
        this.setBalance(balance);
    }

    public void addProcedure(Procedure p, double charge){
        this.proceduresCompleted.put(p,charge);
    }

    public HashMap<Procedure,Double> getProceduresCompleted() {
        return proceduresCompleted;
    }


    public void addPayment(Payment payment){
        this.paymentList.add(payment);
    }

    public ArrayList<Payment> getPaymentList() {
        return paymentList;
    }

    public double getBalance() {
        this.setBalance(updateBalance());
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    private double updateBalance() {
        double total = balance;
        for (Double value : proceduresCompleted.values()){
            total += value;
        }
        for (Payment payment : paymentList){
            total -= payment.getAmount();
        }
        return total;
    }

    @Override
    public String toString() {
        StringBuilder charges = new StringBuilder();
        for (Procedure key : proceduresCompleted.keySet()){
            charges.append(key).append(" Amount charged: ").append(proceduresCompleted.get(key)).append("\n");
        }
        StringBuilder payments = new StringBuilder();
        for (Payment payment : paymentList){
            payments.append(payment.getSource()).append(" Payment: ").append(payment.getAmount()).append("\n");
        }



        return "Procedure History: \n" + charges + "\n" +
                "Payment History: \n" + payments;
    }
}
