package com.company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//TotalBooks Class
public class Display {
    Connection con = JDBC_Connection.getConnection();

    //Method ViewBooks() for displaying data from TotalBooks Class
    public void ViewBooks(int count){
        if(count !=0) {
            final String SQL ="select *from BookDetails";
            try (PreparedStatement stmt = con.prepareStatement(SQL)) {
                System.out.println("Query = "+ stmt);
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    System.out.println("BookID: " + rs.getString("BookID") + "\t" + "Bookname : " + rs.getString("Bookname") + "\t" + "Author:" + rs.getString("Author")+ "\t" +  "Category:"  + rs.getString("Category") + "\t" +"Publishers:"  + rs.getString("Publishers") +"\t" +"Price:"  + rs.getInt("Price"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else{
            System.out.println("TABLE NOT CREATED FOR PERFORMING VIEWBOOKS OPERATION ");
        }
    }
}