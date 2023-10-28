package com.company;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//Using Inheritance
//Class SubBook(Children Class) extends from Class Book(Parent Class)
//SubBook Class
public class SubBook extends Book{

    //Private Attribute
    private String Publishers;
    private int Price;

    //Setter
    public void setPublishers(String Publishers){
        this.Publishers=Publishers;
    }
    public void setPrice(int Price){
        this.Price=Price;
    }
    //Getter
    public String getPublishers() {
        return this.Publishers;
    }
    public int getPrice(){
        return this.Price;
    }

    //Parametarized Constructor
    public SubBook(String values[]){
        super(values[0],values[1],values[2],values[3]);
        this.Publishers=values[4];
        this.Price =Integer.valueOf(values[5]);
    }
    //Constructor
    public SubBook(){

    }

    //Override Concept
    //Method BookCount() for Counting Books based on Publishers from SubBook Class
    //Overridden Method
    @Override
    public void BookCount(String args[]){
        Connection con = JDBC_Connection.getConnection();
        int k=0;
        if(args.length == 2){
            String SQL = "select count(*) from Bookdetails where Publishers="+"'"+args[1]+"'";
            try (PreparedStatement stmt = con.prepareStatement(SQL)) {
                System.out.println("Query = "+ stmt);
                ResultSet rs = stmt.executeQuery(SQL);
                rs.next();
                k = rs.getInt(1);
                System.out.println(args[1] + " -> Count = "+ k);
            } catch (SQLException e) {
                e.printStackTrace();
        }
        }
        else {
            System.out.println("Invalid number of Arguments ");
        }
    }


}

