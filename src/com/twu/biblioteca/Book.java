package com.twu.biblioteca;

public class Book {
    private String title;
    private String author;
    private int yearPublished;
    private boolean checkedOut;

    public Book(String title, String author, int yearPublished, boolean checkedOut) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.checkedOut = checkedOut;
    }

    public String getTitle() {
        return title;
    }

    public String bookInfo() {
        return title +" | "+ author +" | "+ yearPublished;
    }

    public void checkOut()
    {
        if(!checkedOut)
        {
            checkedOut = true;
        }
    }

    public boolean getCheckedOut()
    {
        return checkedOut;
    }
}
