package model.reports;

import java.time.LocalDate;

public class ProcedureFactory {
    public static Procedure getInstance(){
        return new ProcedureImpl();
    }
    public static Procedure getInstance(String code, double cost, String description, LocalDate date){
        return new ProcedureImpl(code,cost,description,date);
    }
}
