package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaApp {

    public static void main(String[] args) {

        List<Book> myBooks = new ArrayList<Book>();
        myBooks.add(new Book("Harry Potter", "J.K", 2013));
        myBooks.add(new Book("Game Of Thrones", "JRR", 2014));
        myBooks.add(new Book("The Shining", "SK", 1977));

        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");

        for (int i = 0; i < myBooks.size(); i++) {
            System.out.println(myBooks.get(i).bookInfo());
        }
    }
}
