package com.twu.biblioteca.service;

import com.twu.biblioteca.BibliotecaApp;
import com.twu.biblioteca.entity.Book;

import java.util.List;
import java.util.Scanner;

public class WelcomeService {

    public void welcome(){
        System.out.println("welcome to bibloteca\n"+
                "here are some options:\n"
        );
    }

    public void displayOptions(){
        System.out.println("1.view books\n"
                +"2.check out a book\n"
                +"3.return a book\n"
                +"4.quit\n"
                +"input your option number:"
        );
    }

    /*
        read options from user
        1.view book list
        2.check out book
        3.return book
        4.quit
     */
    public void readOptions(){
        Scanner in = new Scanner(System.in);
        BookService bookService=new BookService();

        while (in.hasNext()){
            if(!in.hasNextInt()){
                System.out.println("please input valid option number");
            }
            int optionNumber=in.nextInt();
            if(optionNumber==1){
              List<Book>bookList=bookService.viewAllBooks();
              for(Book book:bookList){
                  System.out.println("name: "+book.getName()
                          +" author: "+book.getAuthor()
                          +" publication year:"+book.getYear()
                  );
              }
              displayOptions();
            }else if(optionNumber==2){
                System.out.println("which book do you want to check out?");
                Scanner ic = new Scanner(System.in);
                if(bookService.checkOutBook(ic.nextLine())==1){
                    System.out.println("check out successfully");
                }
                else{
                    System.out.println("check out failed");
                }
                displayOptions();
            }else if(optionNumber==3){
                System.out.println("which book do you want to return");
                Scanner ir = new Scanner(System.in);
                if(bookService.returnBook(ir.nextLine())==1){
                    System.out.println("return successfully");
                }
                else{
                    System.out.println("return failed");
                }
                displayOptions();
            }else if(optionNumber==4){
                System.out.println("bye bye");
                System.exit(0);
            }else{
               System.out.println("please input valid option number");
            }
        }
    }
}
