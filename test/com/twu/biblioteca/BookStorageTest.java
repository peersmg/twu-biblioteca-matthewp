package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BookStorageTest {

    @Test
    public void canAddAvailableBooks() {
        BookStorage bookStorage = new BookStorage();
        List<Book> bookList = new ArrayList<Book>();
        bookList.add(new Book(1,"Test", "Matt", 2019, false));
        bookList.add(new Book(2,"Test1", "Matt1", 2019, false));

        bookStorage.addBook(bookList.get(0));
        bookStorage.addBook(bookList.get(1));

        assertThat(bookStorage.getAvailableBooks(),is(bookList));
    }

    @Test
    public void canAddCheckedBooks(){
        BookStorage bookStorage = new BookStorage();
        List<Book> bookList = new ArrayList<Book>();
        bookList.add(new Book(1,"Test", "Matt", 2019, true));
        bookList.add(new Book(2,"Test1", "Matt1", 2019, true));

        bookStorage.addBook(bookList.get(0));
        bookStorage.addBook(bookList.get(1));

        assertThat(bookStorage.getCheckedOutBooks(),is(bookList));
    }

    @Test
    public void canReturnCheckedBook(){
        BookStorage bookStorage = new BookStorage();
        bookStorage.addBook(new Book(1,"Test", "Matt", 2019, false));
        bookStorage.addBook(new Book(2,"Test1", "Matt1", 2019, true));

        assertThat(bookStorage.returnBook(2),is(true));
    }

    @Test
    public void cannotReturnAvailableBook(){
        BookStorage bookStorage = new BookStorage();
        bookStorage.addBook(new Book(1,"Test", "Matt", 2019, false));
        bookStorage.addBook(new Book(2,"Test1", "Matt1", 2019, true));

        assertThat(bookStorage.returnBook(1),is(false));
    }
}
