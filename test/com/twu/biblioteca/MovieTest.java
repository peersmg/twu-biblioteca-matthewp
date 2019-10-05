package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MovieTest {
    private Movie testingMovie;

    @Before
    public void setup()
    {
        testingMovie = new Movie(1,"Joker", 2018, "Matt", 8, false);
    }

    @Test
    public void movieInfoSetCorrectly()
    {
        assertThat(testingMovie.getDetails(), is("1 | Joker | Matt | 2018 | 8"));
    }

    @Test
    public void movieCheckOut(){
        testingMovie.checkOut();
        assertThat(testingMovie.getCheckedOut(), is(true));
    }
}
