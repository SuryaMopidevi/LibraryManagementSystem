package com.company;
import java.sql.Connection;

//Using Interface(Abstract Method) for Deleting a row from table

public interface DELETION {
    Connection con = JDBC_Connection.getConnection();

    //Abstract Method
    void DELETE(String args[],int count);
}
