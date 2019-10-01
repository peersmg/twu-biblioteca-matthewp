package com.twu.biblioteca;

import java.util.List;
import java.util.Scanner;

public class Menu {
    List<Book> books;
    static final int VALID_OPTIONS = 1;
    boolean applicationRunning = true;

    public Menu(List<Book> books) {
        this.books = books;

        welcomeMessage();

        while (applicationRunning){
            waitForSelection();
        }

    }

    public boolean isApplicationRunning() {
        return applicationRunning;
    }

    public void setApplicationRunning(boolean applicationRunning) {
        this.applicationRunning = applicationRunning;
    }

    private void waitForSelection(){
        boolean validSelection = false;
        int selection = -1;

        while (!validSelection){
            System.out.println("Options: Exit Application [0] Show Books [1] ");
            System.out.println("Please enter selection: ");

            Scanner scanner = new Scanner(System.in);
            selection = scanner.nextInt();

            if(selection > VALID_OPTIONS || selection < 0){
                System.out.println("Please select a valid option!");
            }
            else {
                validSelection = true;
            }
        }
        actOnSelection(selection);
    }

    private void actOnSelection(int selection)
    {
        switch (selection){
            case 1:
                listBooks();
                break;
            case 0:
                setApplicationRunning(false);
                break;
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
