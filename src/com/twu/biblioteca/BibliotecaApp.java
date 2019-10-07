package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {

        ItemStorage bookStorage = new ItemStorage();
        bookStorage.addItem(new Book(145,"Harry Potter", "J.K", 2013, false));
        bookStorage.addItem(new Book(142,"Game Of Thrones", "JRR", 2014, false));
        bookStorage.addItem(new Book(434,"The Shining", "SK", 1977, false));

        ItemStorage movieStorage = new ItemStorage();
        movieStorage.addItem(new Movie(242, "Joker", 2019, "Matthew", 7, false));
        movieStorage.addItem(new Movie(825, "Batman", 2013, "James", 8, false));
        movieStorage.addItem(new Movie(111, "Avengers", 2015, "Edd", 9, false));

        UserRegister userRegister = new UserRegister();
        userRegister.addUser(new User("123-1234", "myPass"));
        userRegister.addUser(new User("111-1111", "password"));

        IOHandler inputOutput = new IOHandler(System.in, System.out);

        Menu menu = new Menu(bookStorage, movieStorage, inputOutput, userRegister);
        menu.runInputListener();
    }
}