package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaApp {

    public static void main(String[] args) {

        BookStorage bookStorage = new BookStorage();
        bookStorage.addBook(new Book(1,"Harry Potter", "J.K", 2013, false));
        bookStorage.addBook(new Book(2,"Game Of Thrones", "JRR", 2014, false));
        bookStorage.addBook(new Book(3,"The Shining", "SK", 1977, false));

        Menu menu = new Menu(bookStorage);
        menu.runLibrary();
    }
}
