package com.twu.biblioteca;

import java.util.List;
import java.util.Scanner;

public class Menu {
    List<Book> books;

    public Menu(List<Book> books) {
        this.books = books;

        welcomeMessage();
        waitForSelection();
    }

    private void waitForSelection(){
        System.out.println("Options: Show Books [1] ");
        System.out.println("Please enter selection: ");
        Scanner scanner = new Scanner(System.in);
        int selection = scanner.nextInt();

        if(selection == 1){
            listBooks();
        }
    }

    private void welcomeMessage(){
        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }

    private void listBooks(){
        for (int i = 0; i < books.size(); i++) {
            System.out.println(books.get(i).bookInfo());
        }
    }
}
