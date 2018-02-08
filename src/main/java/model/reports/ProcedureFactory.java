package model.reports;

public class ProcedureFactory {
    public static Procedure getINstance(){
        return new ProcedureImpl();
    }
}
