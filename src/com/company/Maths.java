package com.company;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//Maths Class
public class Maths {
    Connection con = JDBC_Connection.getConnection();

    //Method Arithematic() for Performing Arithematic Operations based on Price from class Maths
    public void Arithematic(String args[],int count){
        if(count !=0) {
            int k=0;
            if (args.length == 2){
                final String SQL = "select "+args[1]+"(Price)" + "from BookDetails";//sum(Price)

                try (PreparedStatement stmt = con.prepareStatement(SQL)) {
                    System.out.println("Query = "+ stmt);
                    ResultSet rs = stmt.executeQuery(SQL);
                    rs.next();
                    k = rs.getInt(1);
                    System.out.println(args[1]+" = "+ k);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            else {
                System.out.println("Invalid number of Arguments ");
            }
        }
        else{
            System.out.println("TABLE NOT CREATED FOR PERFORMING ARITHEMATIC OPERATION ");
        }
    }
}
