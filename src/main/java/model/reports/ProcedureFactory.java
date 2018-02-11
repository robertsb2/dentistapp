package model.reports;

import java.time.LocalDate;

public class ProcedureFactory {
    /**
     * creates instance of a class that implements Procedure
     * @return instance
     */
    public static Procedure getInstance(){
        return new ProcedureImpl();
    }

    /**
     * creates instance of a class that implements Procedure through overloaded constructor
     * @param code Procedure code in the form of D#####
     * @param cost Standard procedure cost
     * @param description Procedure description
     * @param date date Procedure was completed
     * @return instance
     */
    public static Procedure getInstance(String code, double cost, String description, LocalDate date){
        return new ProcedureImpl(code,cost,description,date);
    }
}
