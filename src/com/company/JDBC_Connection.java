package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class JDBC_Connection {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "mysql003";
    private static final String URL = "jdbc:mysql://localhost:3306/Project";

    public static Connection getConnection(){
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Properties connectionProperties = new Properties();
            connectionProperties.put("user",USERNAME);
            connectionProperties.put("password",PASSWORD);
            con = DriverManager.getConnection(URL,connectionProperties);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}
