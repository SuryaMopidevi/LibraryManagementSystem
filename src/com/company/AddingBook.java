package com.company;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//AddingBook Class
public class AddingBook {
    Connection con = JDBC_Connection.getConnection();

    //Method AddBook() for Adding Book  from AddingBook  Class
    public void AddBook(String args[]){
        if(args.length==7){
            final String SQL = "insert into BookDetails  values(?,?,?,?,?,?)";
            try (PreparedStatement stmt = con.prepareStatement(SQL)) {
                stmt.setString(1,args[1]);
                stmt.setString(2,args[2]);
                stmt.setString(3,args[3]);
                stmt.setString(4,args[4]);
                stmt.setString(5,args[5]);
                stmt.setInt(6, Integer.parseInt(args[6]));
                System.out.println("Query = "+ stmt);
                int rowsAffected = stmt.executeUpdate();
                System.out.println(rowsAffected + " book ADDED.");

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else{
            System.out.println("Invalid number of Arguments ");
        }
    }
}
