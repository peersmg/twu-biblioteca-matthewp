package com.twu.biblioteca;

public class Movie extends Item {

    private String name;
    private int year;
    private String director;
    private int rating;

    public Movie(int id, String name, int year, String director, int rating, boolean checkedOut) {
        super(id, checkedOut);
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
    }

    @Override
    public String getDetails()
    {
        return String.format("%d | %s | %s | %d | %d", id , name, director, year, rating);
    }
}