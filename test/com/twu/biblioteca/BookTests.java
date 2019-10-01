package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BookTests {

    private Book testingBook;

    @Before
    public void setup(){
        testingBook = new Book("Test");
    }

    @Test
    public void bookTitleReturnsCorrectly()
    {
        assertThat(testingBook.getTitle(),is("Test"));
    }

}
