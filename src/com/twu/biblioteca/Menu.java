package com.twu.biblioteca;

import java.util.Scanner;

public class Menu {
    BookStorage bookStorage;
    boolean applicationRunning = true;
    Scanner inputScanner;

    public Menu(BookStorage bookStorage) {
        this.bookStorage = bookStorage;
        this.inputScanner = new Scanner(System.in);
        welcomeMessage();
    }

    public void runInputListener(){
        while (applicationRunning){
            getUserSelection();
        }
    }

    public void setBooks(BookStorage bookStorage) {
        this.bookStorage = bookStorage;
    }

    public void setApplicationRunning(boolean applicationRunning) {
        this.applicationRunning = applicationRunning;
    }

    private void getUserSelection(){

        System.out.println("Options: Exit Application [0] | Show Available Books [1] | Check out book [2] | Show checked out books [3] | Return a book [4]");
        System.out.println("Please enter selection: ");

        int selection = readNextInt();

        System.out.println(actOnSelection(selection));
    }

    private int readNextInt()
    {
        String input = inputScanner.next();

        try {
            return Integer.parseInt(input);
        }
        catch (NumberFormatException nfe)
        {
            return -1;
        }

    }

    private String checkoutBook()
    {
        String response;

        System.out.println("Please enter book ID to checkout or 0 to cancel: ");

        int selection = readNextInt();

        if(selection == 0){
            return "Cancelling checkout.";
        }

        boolean result = bookStorage.checkoutBook(selection);

        if(!result){
            response = "Sorry, that book is not available. Please enter a valid book ID!";
        }
        else {
            response = "Thank you! Enjoy the book";
        }

        return response;
    }

    private String returnBook()
    {
        String response;

        System.out.println("Please enter book ID to return or 0 to cancel: ");

        int selection = readNextInt();

        if(selection == 0){
            return "Cancelling return.";
        }

        boolean result = bookStorage.returnBook(selection);

        if(!result){
            response = "That is not a valid book to return.";
        }
        else {
            response = "Thank you for returning the book";
        }

        return response;
    }


    public String actOnSelection(int selection)
    {
        String response;
        switch (selection){
            case 1:
                response = bookStorage.printAvailableBooks();
                break;
            case 2:
                response = checkoutBook();
                break;
            case 3:
                response = bookStorage.printCheckedOutBooks();
                break;
            case 4:
                response = returnBook();
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
}
