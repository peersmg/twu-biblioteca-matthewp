package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MenuTests {
    private Menu testMenu;

    @Before
    void init(){
        List<Book> dummyBooks = new ArrayList<Book>();
        testMenu = new Menu(dummyBooks);
    }

    @Test
    void optionOneReturnsBookList()
    {
        testMenu.actOnSelection(1);
    }
}
