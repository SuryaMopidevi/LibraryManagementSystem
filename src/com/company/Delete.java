package com.company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Delete implements DELETION{

    Connection con = JDBC_Connection.getConnection();

    //Abstract Method DELETE() for deleting row based on Author from Interface DELETION

    public void DELETE(String args[],int count) {

        if (count != 0) {
            if (args.length == 2) {
                final String SQL = "DELETE FROM BookDetails where Author = " + "'" + args[1] + "'";
                try (PreparedStatement stmt = con.prepareStatement(SQL)) {
                    System.out.println("Query = "+ stmt);
                    int rowsAffected = stmt.executeUpdate();
                    System.out.println(rowsAffected + " row DELETED.");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Invalid number of Arguments ");
            }
        }
            else{
                System.out.println("TABLE NOT CREATED FOR PERFORMING DELETE OPERATION ");
            }
        }
}
