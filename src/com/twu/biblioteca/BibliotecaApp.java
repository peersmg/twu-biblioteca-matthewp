package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaApp {

    public static void main(String[] args) {

        List<Book> myBooks = new ArrayList<Book>();
        myBooks.add(new Book("Harry Potter", "J.K", 2013, false));
        myBooks.add(new Book("Game Of Thrones", "JRR", 2014, false));
        myBooks.add(new Book("The Shining", "SK", 1977, false));

        Menu menu = new Menu(myBooks);
        menu.runLibrary();
    }
}
