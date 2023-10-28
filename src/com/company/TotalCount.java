package com.company;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//TotalCount Class
public class TotalCount {
    Connection con = JDBC_Connection.getConnection();

    //Method Count() for Counting  from TotalCount Class
    public void Count(String args[],int count){
        if(count !=0) {
            if (args.length == 2){
                final String SQL = " select " +args[1] +","+"count(*) from BookDetails group by " +args[1] ;
                try (PreparedStatement stmt = con.prepareStatement(SQL)) {
                    System.out.println("Query = "+ stmt);
                    ResultSet rs = stmt.executeQuery();
                    while (rs.next()) {
                        System.out.println(rs.getString(args[1]) + " = " + rs.getInt("count(*)"));
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            else {
                System.out.println("Invalid number of Arguments ");
            }

        }else{
            System.out.println("TABLE NOT CREATED FOR PERFORMING COUNTING OPERATION ");
        }
    }
}