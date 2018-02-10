package model.reports;

public class ProcedureFactory {
    public static Procedure getInstance(){
        return new ProcedureImpl();
    }
}
