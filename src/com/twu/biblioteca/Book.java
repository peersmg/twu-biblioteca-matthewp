package com.twu.biblioteca;

public class Book extends Item {
    private String title;
    private String author;
    private int yearPublished;

    public Book(int id, String title, String author, int yearPublished, boolean checkedOut) {
        super(id, checkedOut);
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String getDetails() {
        return String.format("%d | %s | %s | %d", id , title, author, yearPublished);
    }

}
