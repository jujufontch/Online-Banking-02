package Beans;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Admin {

    sql SQl = new sql();

    Connection con ;

    Statement phrase;

    public ResultSet showAllTran(){

        ResultSet rs = SQl.Operation("BankOPeration");
        
        return rs ;


    }

    public ResultSet showAllCustomerInfo(){

        ResultSet rs = sql.result();
        
        return rs;

    }

    public ResultSet customerDeposit(String name){

        ResultSet rs = SQl.Operation(name+"deposits");
        
        return rs ;


    }

    public ResultSet customerWithdrawal(String name){

        ResultSet rs = SQl.Operation(name+"withrawal");
       
        return rs;

    }

    public ResultSet customerTransaction(String name){

        ResultSet rs = SQl.Operation(name+"transactions");
        
        return rs;


    }

}

