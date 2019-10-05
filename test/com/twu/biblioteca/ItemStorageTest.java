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
