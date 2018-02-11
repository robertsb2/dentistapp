package model.patient;

import model.reports.Procedure;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class PatientAccount implements Serializable {
    private HashMap<Procedure,Double> proceduresCompleted = new HashMap<>();
    private ArrayList<Payment> paymentList = new ArrayList<>();
    private double balance;

    /**
     * default constructor
     */
    public PatientAccount() {
    }

    /**
     * overloaded constructor
     * @param balance patient's account balance
     */
    public PatientAccount(double balance) {
        this.setBalance(balance);
    }

    /**
     * adds completed procedure to patient's account
     * @param p procedure
     * @param charge amount actually charged for procedure
     */
    public void addProcedure(Procedure p, double charge){
        if (p == null){
            throw new IllegalArgumentException("procedure cannot be null");
        }
        if(charge > p.getCost()){
            throw new IllegalArgumentException("charge cannot exceed standard cost");
        }
        this.proceduresCompleted.put(p,charge);
    }

    /**
     *
     * @return procedures completed
     */
    public HashMap<Procedure,Double> getProceduresCompleted() {
        return proceduresCompleted;
    }

    /**
     * add payment to patient's account
     * @param payment Payment object
     */
    public void addPayment(Payment payment){
        if (payment == null){
            throw new IllegalArgumentException("payment cannot be null");
        }
        this.paymentList.add(payment);
    }

    /**
     *
     * @return payments
     */
    public ArrayList<Payment> getPaymentList() {
        return paymentList;
    }

    /**
     *
     * @return balance
     */
    public double getBalance() {
        this.setBalance(updateBalance());
        return balance;
    }

    /**
     * manually override patient balance
     * @param balance new balance amount
     */
    public void setBalance(double balance) {
        if (balance < 0){
            throw new IllegalArgumentException("balance cannot be negative");
        }
        this.balance = balance;
    }


    /**
     *
     * @return patient account info as a string
     */
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

    private double updateBalance() {
        double total = 0;
        for (Double value : proceduresCompleted.values()){
            total += value;
        }
        for (Payment payment : paymentList){
            total -= payment.getAmount();
        }
        return total;
    }
}
