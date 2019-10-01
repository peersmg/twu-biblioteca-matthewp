package com.twu.biblioteca;

import java.util.List;

public class Menu {
    List<Book> books;

    public Menu(List<Book> books) {
        this.books = books;

        welcomeMessage();
        listBooks();
    }

    private void welcomeMessage(){
        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }

    private void listBooks(){
        for (int i = 0; i < books.size(); i++) {
            System.out.println(books.get(i).bookInfo());
        }
    }
}
