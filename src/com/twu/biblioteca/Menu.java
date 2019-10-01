package com.twu.biblioteca;

import java.util.Scanner;

public class Menu {
    BookStorage bookStorage;
    boolean applicationRunning = true;

    public Menu(BookStorage bookStorage) {
        this.bookStorage = bookStorage;

        welcomeMessage();
    }

    public void runLibrary(){
        while (applicationRunning){
            waitForSelection();
        }
    }

    public void setBooks(BookStorage bookStorage) {
        this.bookStorage = bookStorage;
    }

    public boolean isApplicationRunning() {
        return applicationRunning;
    }

    public void setApplicationRunning(boolean applicationRunning) {
        this.applicationRunning = applicationRunning;
    }

    private void waitForSelection(){

        int selection = -1;

        System.out.println("Options: Exit Application [0] | Show Available Books [1] | Check out book [2] | Show checked out books [3] | Return a book [4]");
        System.out.println("Please enter selection: ");

        Scanner scanner = new Scanner(System.in);
        selection = scanner.nextInt();

        System.out.println(actOnSelection(selection));
    }

    private String checkoutBook()
    {
        String response = "";

        System.out.println("Please enter book number to checkout or 0 to cancel: ");

        Scanner scanner = new Scanner(System.in);
        int selection = scanner.nextInt();

        if(selection == 0){
            return "Cancelling checkout.";
        }

        boolean result = bookStorage.checkoutBook(selection);

        if(!result){
            response = "Sorry, that book is not available. Please select a valid option!";
        }
        else {
            response = "Thank you! Enjoy the book";
        }

        return response;
    }

    private String returnBook()
    {
        String response = "";

        System.out.println("Please enter book number to return or 0 to cancel: ");

        Scanner scanner = new Scanner(System.in);
        int selection = scanner.nextInt();

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
