package com.company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Creation {
    Connection con = JDBC_Connection.getConnection();

    public void create( SubBook stud ) {
        final String SQL = "insert into BookDetails  values(?,?,?,?,?,?)";
        try (PreparedStatement stmt = con.prepareStatement(SQL)) {
            stmt.setString(1, stud.getBookID());
            stmt.setString(2, stud.getBookname());
            stmt.setString(3, stud.getAuthor());
            stmt.setString(4, stud.getCategory());
            stmt.setString(5, stud.getPublishers());
            stmt.setInt(6, stud.getPrice());
            System.out.println("Query = "+ stmt);
            int rowsAffected = stmt.executeUpdate();
            System.out.println(rowsAffected + " book INSERTED ");
        }
            catch(SQLException e) {
                e.printStackTrace();
        }
    }
}
