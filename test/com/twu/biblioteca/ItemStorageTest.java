package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ItemStorageTest {

    @Test
    public void canAddAvailableBooks() {
        ItemStorage itemStorage = new ItemStorage();
        List<Book> bookList = new ArrayList<Book>();
        bookList.add(new Book(1,"Test", "Matt", 2019, false));
        bookList.add(new Book(2,"Test1", "Matt1", 2019, false));

        itemStorage.addItem(bookList.get(0));
        itemStorage.addItem(bookList.get(1));

        assertThat(itemStorage.getAvailableItems(),is(bookList));
    }

    @Test
    public void canAddAvailableMovies() {
        ItemStorage itemStorage = new ItemStorage();
        List<Movie> movieList = new ArrayList<>();
        movieList.add(new Movie(1,"Test", 2019, "Matt", 5,false));
        movieList.add(new Movie(2,"Test1", 2019, "Matt", 5,false));

        itemStorage.addItem(movieList.get(0));
        itemStorage.addItem(movieList.get(1));

        assertThat(itemStorage.getAvailableItems(),is(movieList));
    }

    @Test
    public void canPrintAvailableBooks()
    {
        ItemStorage itemStorage = new ItemStorage();
        List<Book> bookList = new ArrayList<Book>();
        bookList.add(new Book(1,"Test", "Matt", 2019, false));
        bookList.add(new Book(2,"Test1", "Matt1", 2019, false));
        itemStorage.addItem(bookList.get(0));
        itemStorage.addItem(bookList.get(1));

        assertThat(itemStorage.printAvailableItems().get(0), is(bookList.get(0).getDetails()));
    }

    @Test
    public void canPrintAvailableMovies()
    {
        ItemStorage itemStorage = new ItemStorage();
        List<Movie> movieList = new ArrayList<Movie>();
        movieList.add(new Movie(1,"Test", 2019, "Matt", 5,false));
        movieList.add(new Movie(2,"Test", 2019, "Matt", 5,false));
        itemStorage.addItem(movieList.get(0));
        itemStorage.addItem(movieList.get(1));

        assertThat(itemStorage.printAvailableItems().get(0), is(movieList.get(0).getDetails()));
    }


    @Test
    public void canAddCheckedBooks(){
        ItemStorage itemStorage = new ItemStorage();
        List<Book> bookList = new ArrayList<Book>();
        bookList.add(new Book(1,"Test", "Matt", 2019, true));
        bookList.add(new Book(2,"Test1", "Matt1", 2019, true));

        itemStorage.addItem(bookList.get(0));
        itemStorage.addItem(bookList.get(1));

        assertThat(itemStorage.getCheckedOutItems(),is(bookList));
    }

    @Test
    public void canReturnCheckedBook(){
        ItemStorage itemStorage = new ItemStorage();
        itemStorage.addItem(new Book(1,"Test", "Matt", 2019, false));
        itemStorage.addItem(new Book(2,"Test1", "Matt1", 2019, true));

        assertThat(itemStorage.returnItem(2),is(true));
    }

    @Test
    public void cannotReturnAvailableBook(){
        ItemStorage itemStorage = new ItemStorage();
        itemStorage.addItem(new Book(1,"Test", "Matt", 2019, false));
        itemStorage.addItem(new Book(2,"Test1", "Matt1", 2019, true));

        assertThat(itemStorage.returnItem(1),is(false));
    }
}
