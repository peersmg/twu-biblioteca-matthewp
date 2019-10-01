package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BookStorage {
    private HashMap<Integer,Book> availableBooks = new HashMap<Integer,Book>();
    private HashMap<Integer,Book> checkedOutBooks = new HashMap<Integer,Book>();

    public BookStorage() {
    }

    public void addBook(Book newBook){
        if(newBook.getCheckedOut())
        {
            checkedOutBooks.put(newBook.getId(), newBook);
        }
        else{
            availableBooks.put(newBook.getId(), newBook);
        }

    }

    public boolean returnBook(int id){
        if(checkedOutBooks.containsKey(id)){
            availableBooks.put(id, checkedOutBooks.get(id));
            checkedOutBooks.remove(id);
            return true;
        }
        return false;
    }

    public List<Book> getAvailableBooks() {
        return new ArrayList<Book>(availableBooks.values());
    }

    public List<Book> getCheckedOutBooks() {
        return new ArrayList<Book>(checkedOutBooks.values());
    }

    public String printAvailableBooks()
    {
        String bookList = "";
        for (Book book: availableBooks.values()){
            bookList += book.bookInfo() + "\n";
        }
        return bookList;
    }

    public String printCheckedOutBooks()
    {
        String bookList = "";
        for (Book book: checkedOutBooks.values()){
            bookList += book.bookInfo() + "\n";
        }
        return bookList;
    }


    public boolean checkoutBook(int id)
    {
        if(availableBooks.containsKey(id)){
            checkedOutBooks.put(id, availableBooks.get(id));
            availableBooks.remove(id);
            return true;
        }
        return false;
    }
}
