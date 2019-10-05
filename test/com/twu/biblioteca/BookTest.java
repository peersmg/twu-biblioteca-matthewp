package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BookTest {

    private Book testingBook;

    @Before
    public void setup(){
        testingBook = new Book(1,"Test", "Matt", 2018, false);
    }

    @Test
    public void bookTitleReturnsCorrectly()
    {
        assertThat(testingBook.getTitle(),is("Test"));
    }

    @Test
    public void bookInfoSetCorrectly() {
        assertThat(testingBook.formattedBookInfo(), is("1 | Test | Matt | 2018"));
    }

    @Test
    public void bookCheckOut(){
        testingBook.checkOut();
        assertThat(testingBook.getCheckedOut(), is(true));
    }

}
