package com.twu.biblioteca;

public class Book {
    private int id;
    private String title;
    private String author;
    private int yearPublished;
    private boolean checkedOut;

    public Book(int id, String title, String author, int yearPublished, boolean checkedOut) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.checkedOut = checkedOut;
    }

    public String getTitle() {
        return title;
    }

    public int getId() {
        return id;
    }

    public String bookInfo() {
        return id + " | "+title +" | "+ author +" | "+ yearPublished;
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
