package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {

        ItemStorage bookStorage = new ItemStorage();
        bookStorage.addItem(new Book(145,"Harry Potter", "J.K", 2013, false));
        bookStorage.addItem(new Book(142,"Game Of Thrones", "JRR", 2014, false));
        bookStorage.addItem(new Book(434,"The Shining", "SK", 1977, false));

        IOHandler inputOutput = new IOHandler(System.in, System.out);

        Menu menu = new Menu(bookStorage, inputOutput);
        menu.runInputListener();
    }
}
