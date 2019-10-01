package com.twu.biblioteca;

import java.util.List;
import java.util.Scanner;

public class Menu {
    List<Book> books;
    static final int VALID_OPTIONS = 3;
    boolean applicationRunning = true;

    public Menu(List<Book> books) {
        this.books = books;

        welcomeMessage();
    }

    public void runLibrary(){
        while (applicationRunning){
            waitForSelection();
        }
    }

    public void setBooks(List<Book> books) {
        this.books = books;
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
            System.out.println("Options: Exit Application [0] | Show Available Books [1] | Check out book [2] | Show checked out books [3]");
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

        System.out.println(actOnSelection(selection));
    }

    private String waitForCheckout()
    {
        String response = "";

        boolean validSelection = false;
        int selection = -1;

        while (!validSelection){
            System.out.println("Please enter book number to checkout or 0 to cancel: ");

            Scanner scanner = new Scanner(System.in);
            selection = scanner.nextInt();

            if(selection == 0)
            {
                return "Checkout aborted";
            }

            if(selection > books.size() || selection < 0){
                System.out.println("Sorry, that book is not available. Please select a valid option!");
            }
            else if(books.get(selection-1).getCheckedOut())
            {
                System.out.println("Sorry, that book is not available.");
            }
            else {
                validSelection = true;
            }
        }


        books.get(selection-1).checkOut();
        response = "Thank you! Enjoy the book";


        return response;
    }

    public String actOnSelection(int selection)
    {
        String response = "";
        switch (selection){
            case 1:
                response = listAvailableBooks();
                break;
            case 2:
                response = waitForCheckout();
                break;
            case 3:
                response = listCheckedOutBooks();
                break;
            case 0:
                setApplicationRunning(false);
                response = "Exiting application...";
                break;
            default:
                response = "Selection Error!";
                break;
        }

        return response;
    }

    private void welcomeMessage(){
        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }

    private String listAvailableBooks(){
        String response = "";
        for (int i = 0; i < books.size(); i++) {
            if(!books.get(i).getCheckedOut()) {
                response += (i+1) +". "+ books.get(i).bookInfo() + "\n";
            }
        }

        return response;
    }

    private String listCheckedOutBooks(){
        String response = "";
        for (int i = 0; i < books.size(); i++) {
            if(books.get(i).getCheckedOut()) {
                response += (i+1) +". "+ books.get(i).bookInfo() + "\n";
            }
        }

        return response;
    }
}
