package com.company;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        int count;
        count = Counting.DatabaseCount();
        //CRUD Operations
        Creation c = new Creation();
        Delete d = new Delete();
        Updation u = new Updation();
        SearchingString s = new SearchingString();
        SearchingInt i=new SearchingInt();
        Inserting p = new Inserting();
        Book b = new Book();
        SubBook k = new SubBook();
        AddingBook a=new AddingBook();
        TotalCount t=new TotalCount();
        Display v =new Display();
        Maths m =new Maths();
        //Using Collection Concept
        List<SubBook> book = p.CsvData();
        if (args.length > 0) {

            switch (args[0]) {

                case "-C":
                    for (SubBook books : book) {
                        c.create(books);
                    }
                    break;
                case "-D":
                    d.DELETE(args,count);
                    break;
                case "-U":
                    u.Update(args,count);
                    break;
                case "-S":
                    s.Search(args,count);
                    break;
                case "-I":
                    i.Search(args,count);
                    break;
                case "-B":
                    b.BookCount(args);
                    break;
                case "-K":
                    k.BookCount(args);
                    break;
                case "-A":
                    a.AddBook(args);
                    break;
                case "-T":
                    t.Count(args,count);
                    break;
                case "-V":
                    v.ViewBooks(count);
                    break;
                case "-M":
                    m.Arithematic(args,count);
                    break;
                case "-E":
                    System.out.println("EXIT POINT ");
                    break;
                default:
                    System.out.println("PROGRAM ENDS ");
            }
        }else{
            System.out.println("Input Arguments Information : ");
            System.out.println(" -E for Exit");
            System.out.println(" -C for Creation of the Table");
            System.out.println(" -I for Searching based on Price");
            System.out.println(" -D for Deletion based on Author");
            System.out.println(" -T for Counting of respective fields");
            System.out.println(" -S for Searching based on Publishers");
            System.out.println(" -V for Printing all Books in a library");
            System.out.println(" -B for Counting Books based on Category");
            System.out.println(" -K for Counting Books based on Publishers");
            System.out.println(" -U for Updation based on BookID for BookName");
            System.out.println(" -M for Arithematic Operations(Sum,Avg,Variance,StdDev,Min,Max) based on Price");
            System.out.println(" -A for Adding book with Parameters BookID,BookName,Author,Category,Publishers,Price");
        }
    }

}