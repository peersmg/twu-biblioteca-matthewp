package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MenuTest {
    private Menu testMenu;
    private static final int PRINT_ALL_SELECTION = 1;
    private static final int PRINT_CHECKED_OUT_SELECTION = 3;

    @Before
    public void init(){
        BookStorage dummyBooks = new BookStorage();
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        testMenu = new Menu(dummyBooks, new IOHandler(new ByteArrayInputStream("3".getBytes()), output));
    }

    @Test
    public void optionOneReturnsBookList()
    {
        BookStorage dummyBooks = new BookStorage();
        dummyBooks.addBook(new Book(1,"Test", "Matt", 2019, false));
        dummyBooks.addBook(new Book(2,"Test1", "Matt1", 2019, false));
        testMenu.setBooks(dummyBooks);

        assertThat(testMenu.actOnSelection(PRINT_ALL_SELECTION), is("1 | Test | Matt | 2019\n2 | Test1 | Matt1 | 2019"));
    }

    @Test
    public void checkedOutBookNotInAvailableList(){
        BookStorage dummyBooks = new BookStorage();
        dummyBooks.addBook(new Book(1,"Test", "Matt", 2019, false));
        dummyBooks.addBook(new Book(2,"Test1", "Matt1", 2019, true));
        testMenu.setBooks(dummyBooks);

        int printBookSelection = 1;
        assertThat(testMenu.actOnSelection(PRINT_ALL_SELECTION), is("1 | Test | Matt | 2019"));
    }

    @Test
    public void checkedOutBookInNotAvailableList(){
        BookStorage dummyBooks = new BookStorage();
        dummyBooks.addBook(new Book(1,"Test", "Matt", 2019, false));
        dummyBooks.addBook(new Book(2,"Test1", "Matt1", 2019, true));
        testMenu.setBooks(dummyBooks);

        assertThat(testMenu.actOnSelection(PRINT_CHECKED_OUT_SELECTION), is("2 | Test1 | Matt1 | 2019\n"));
    }
}
