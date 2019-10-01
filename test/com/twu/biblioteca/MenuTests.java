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
        List<Book> dummyBooks = new ArrayList<Book>();
        testMenu = new Menu(dummyBooks);
    }

    @Test
    public void optionOneReturnsBookList()
    {
        List<Book> dummyBooks = new ArrayList<Book>();
        dummyBooks.add(new Book("Test", "Matt", 2019, false));
        dummyBooks.add(new Book("Test1", "Matt1", 2019, false));
        testMenu.setBooks(dummyBooks);

        assertThat(testMenu.actOnSelection(1), is("Test | Matt | 2019\nTest1 | Matt1 | 2019\n"));
    }

    @Test
    public void checkedOutBookNotInList(){
        List<Book> dummyBooks = new ArrayList<Book>();
        dummyBooks.add(new Book("Test", "Matt", 2019, false));
        dummyBooks.add(new Book("Test1", "Matt1", 2019, true));
        testMenu.setBooks(dummyBooks);

        assertThat(testMenu.actOnSelection(1), is("Test | Matt | 2019\n"));
    }


}
