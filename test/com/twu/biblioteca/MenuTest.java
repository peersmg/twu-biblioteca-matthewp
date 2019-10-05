package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

public class MenuTest {
    private Menu testMenu;
    private static final int PRINT_ALL_SELECTION = 1;
    private static final int PRINT_CHECKED_OUT_SELECTION = 3;

    @Before
    public void init(){
        ItemStorage dummyBooks = new ItemStorage();
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        testMenu = new Menu(dummyBooks, new IOHandler(new ByteArrayInputStream("3".getBytes()), output));
    }

    @Test
    public void optionOneReturnsBookList()
    {
        ItemStorage dummyBooks = new ItemStorage();
        dummyBooks.addItem(new Book(1,"Test", "Matt", 2019, false));
        dummyBooks.addItem(new Book(2,"Test1", "Matt1", 2019, false));
        testMenu.setBooks(dummyBooks);

        assertThat(testMenu.actOnSelection(PRINT_ALL_SELECTION), is("1 | Test | Matt | 2019\n2 | Test1 | Matt1 | 2019"));
    }

    @Test
    public void checkedOutBookNotInAvailableList(){
        ItemStorage dummyBooks = new ItemStorage();
        dummyBooks.addItem(new Book(1,"Test", "Matt", 2019, false));
        dummyBooks.addItem(new Book(2,"Test1", "Matt1", 2019, true));
        testMenu.setBooks(dummyBooks);

        assertThat(testMenu.actOnSelection(PRINT_ALL_SELECTION), is("1 | Test | Matt | 2019"));
        assertThat(testMenu.actOnSelection(PRINT_ALL_SELECTION), is(not("1 | Test1 | Matt1 | 2019")));
    }

    @Test
    public void checkedOutBookInNotAvailableList(){
        ItemStorage dummyBooks = new ItemStorage();
        dummyBooks.addItem(new Book(1,"Test", "Matt", 2019, false));
        dummyBooks.addItem(new Book(2,"Test1", "Matt1", 2019, true));
        testMenu.setBooks(dummyBooks);

        assertThat(testMenu.actOnSelection(PRINT_CHECKED_OUT_SELECTION), is("2 | Test1 | Matt1 | 2019\n"));
    }
}
