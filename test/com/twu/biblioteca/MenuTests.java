package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MenuTests {
    private Menu testMenu;

    @Before
    public void init(){
        BookStorage dummyBooks = new BookStorage();
        testMenu = new Menu(dummyBooks);
    }

    @Test
    public void optionOneReturnsBookList()
    {
        BookStorage dummyBooks = new BookStorage();
        dummyBooks.addBook(new Book(1,"Test", "Matt", 2019, false));
        dummyBooks.addBook(new Book(2,"Test1", "Matt1", 2019, false));
        testMenu.setBooks(dummyBooks);

        assertThat(testMenu.actOnSelection(1), is("1 | Test | Matt | 2019\n2 | Test1 | Matt1 | 2019\n"));
    }

    @Test
    public void checkedOutBookNotInAvailableList(){
        BookStorage dummyBooks = new BookStorage();
        dummyBooks.addBook(new Book(1,"Test", "Matt", 2019, false));
        dummyBooks.addBook(new Book(2,"Test1", "Matt1", 2019, true));
        testMenu.setBooks(dummyBooks);

        assertThat(testMenu.actOnSelection(1), is("1 | Test | Matt | 2019\n"));
    }

    @Test
    public void checkedOutBookInNotAvailableList(){
        BookStorage dummyBooks = new BookStorage();
        dummyBooks.addBook(new Book(1,"Test", "Matt", 2019, false));
        dummyBooks.addBook(new Book(2,"Test1", "Matt1", 2019, true));
        testMenu.setBooks(dummyBooks);

        assertThat(testMenu.actOnSelection(3), is("2 | Test1 | Matt1 | 2019\n"));
    }
}
