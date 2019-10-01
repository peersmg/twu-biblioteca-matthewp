package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class BookStorage {
    List<Book> books = new ArrayList<Book>();

    public BookStorage() {
    }

    public void addBook(Book newBook){
        books.add(newBook);
    }
}
