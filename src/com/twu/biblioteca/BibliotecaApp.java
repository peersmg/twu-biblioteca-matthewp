package com.twu.biblioteca;

import java.io.PrintWriter;
import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {

        BookStorage bookStorage = new BookStorage();
        bookStorage.addBook(new Book(145,"Harry Potter", "J.K", 2013, false));
        bookStorage.addBook(new Book(142,"Game Of Thrones", "JRR", 2014, false));
        bookStorage.addBook(new Book(434,"The Shining", "SK", 1977, false));

        IOHandler inputOutput = new IOHandler(new Scanner(System.in), new PrintWriter(System.out));

        Menu menu = new Menu(bookStorage);
        menu.runInputListener();
    }
}
