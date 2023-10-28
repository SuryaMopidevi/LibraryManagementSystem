package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

public class Inserting {
    public List<SubBook> CsvData(){
        List<SubBook> books = new ArrayList<>();

        try {
            String key ;
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\DELL\\Desktop\\LibraryMiniProject\\LibraryMiniProject\\src\\INFORMATION.csv"));
            while ((key = reader.readLine()) != null) {
               String temp[]=key.split(",");
                SubBook book = new SubBook(temp);
                books.add(book);
            }
            reader.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return books;
    }
}
