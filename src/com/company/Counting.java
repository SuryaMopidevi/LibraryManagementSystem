package com.company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//Counting Class
public class Counting {

    //Method for Counting Rows in a Database
    public static int DatabaseCount() {
        int k=0;
        Connection con = JDBC_Connection.getConnection();
        String SQL = "select count(*) from BookDetails";
        try (PreparedStatement stmt = con.prepareStatement(SQL)) {
            ResultSet rs = stmt.executeQuery(SQL);
            rs.next();
             k = rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return k;
    }
}


