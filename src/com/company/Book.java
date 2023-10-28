package com.company;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//Book Class
public class Book {

    //private Attributes
    private String BookID;
    private String Bookname;
    private String Author;
    private String Category;

    //Setters for Attributes
    public void setBookID(String BookID){
        this.BookID=BookID;
    }
    public void setBookname(String Bookname){
        this.Bookname=Bookname;
    }
    public void setAuthor(String Author){
        this.Author=Author;
    }
    public void setCategory(String Category){
        this.Category=Category;
    }

    //Getters for Attributes
    public String getBookID(){
        return this.BookID;
    }
    public String getBookname(){
        return this.Bookname;
    }
    public String getAuthor(){
        return this.Author;
    }
    public String getCategory(){
        return this.Category;
    }

    //Parametarized Constructor
    public Book(String BookID,String Bookname,String Author,String Category){
        this.BookID=BookID;
        this.Bookname=Bookname;
        this.Author=Author;
        this.Category=Category;
    }
    //Override Concept
    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s",this.BookID,this.Bookname,this.Author,this.Category);
    }
    //Constructor
    public Book(){

    }

    //Method BookCount() for Counting Books based on Category from Book Class
    public void BookCount(String args[]){
        Connection con = JDBC_Connection.getConnection();
        int k=0;
        if(args.length == 2){
            String SQL = "select count(*) from Bookdetails where Category= "+"'"+args[1]+"'";
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