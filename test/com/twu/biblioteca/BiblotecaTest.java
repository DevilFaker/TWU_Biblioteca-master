package com.twu.biblioteca;

import com.twu.biblioteca.service.BookService;
import org.junit.Assert;
import org.junit.Test;
import com.twu.biblioteca.service.WelcomeService;

public class BiblotecaTest {

    WelcomeService welcomeService = new WelcomeService();
    BookService bookService=new BookService();

    @Test
    public void testReadOptionNumber(){
        welcomeService.displayOptions();
        welcomeService.readOptions();
    }

    @Test
    public void testViewBooks(){
        Assert.assertEquals(2,bookService.viewAllBooks().size());
    }

    @Test
    public void testCheckOutBooks(){
        Assert.assertEquals(1,bookService.checkOutBook("war"));
        Assert.assertEquals(0,bookService.checkOutBook("war"));
    }

    @Test
    public void testReturnBooks(){
       Assert.assertEquals(1,bookService.returnBook("war"));
       Assert.assertEquals(0,bookService.returnBook("war"));
    }
}
