package com.company;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//Updation Class
public class Updation {
    Connection con = JDBC_Connection.getConnection();

    //Method Update() for updating BookName by BookID from Updation Class
    public void Update(String args[],int count){
        if(count !=0) {
            if (args.length == 3){
                final String SQL = "Update BookDetails set BookName = " +"'" + args[1] +"'" +"where BookID = " + "'"+args[2]+"'";
                try (PreparedStatement stmt = con.prepareStatement(SQL)) {
                    System.out.println("Query = "+ stmt);
                    int rowsAffected = stmt.executeUpdate();
                    System.out.println(rowsAffected + " row UPDATED.");

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            else {
                System.out.println("Invalid number of Arguments ");
            }

        }else{
            System.out.println("TABLE NOT CREATED FOR PERFORMING UPDATE OPERATION ");
        }
    }
}
