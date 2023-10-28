package com.company;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//SearchingString Class
public class SearchingString {
    Connection con = JDBC_Connection.getConnection();

    //Method Search() for Searching Books based on Publishers from class SearchingString
    public void Search(String args[],int count){
        if(count !=0) {
            if (args.length == 2){
                final String SQL = "select *from BookDetails where Publishers = " + "'"+args[1]+"'";
                try (PreparedStatement stmt = con.prepareStatement(SQL)) {
                    System.out.println("Query = "+ stmt);
                    ResultSet rs = stmt.executeQuery();
                    while (rs.next()) {
                        System.out.println("\nBookID: " + rs.getString("BookID") + "\n" + "Bookname : " + rs.getString("Bookname") + "\n" + "Author:" + rs.getString("Author")+ "\n" +  "Category:"  + rs.getString("Category") + "\n" +"Publishers:"  + rs.getString("Publishers")+ "\n" +"Price:" + rs.getInt("Price"));
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            else {
                System.out.println("Invalid number of Arguments ");
            }
        }
        else{
            System.out.println("TABLE NOT CREATED FOR PERFORMING SEARCH OPERATION FOR STRING COLUMN");
        }
    }
}
