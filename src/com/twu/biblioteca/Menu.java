package com.twu.biblioteca;

import java.util.List;
import java.util.Scanner;

public class Menu {
    List<Book> books;
    static final int VALID_OPTIONS = 2;
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
            System.out.println("Options: Exit Application [0] Show Books [1] Check out book [2]");
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

    private String wairForCheckout()
    {
        String response = "";

        boolean validSelection = false;
        int selection = -1;

        while (!validSelection){
            System.out.println("Please enter book number to checkout or 0 to cancel: ");

            Scanner scanner = new Scanner(System.in);
            selection = scanner.nextInt();

            if(selection > books.size() || selection < 0){
                System.out.println("Please select a valid option!");
            }
            else {
                validSelection = true;
            }
        }

        if(selection == 0)
        {
            response = "Checkout aborted";
        }
        else
        {
            books.get(selection-1).checkOut();
            response = "Thank you! Enjoy the book";
        }

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
                response = wairForCheckout();
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
        String responce = "";
        for (int i = 0; i < books.size(); i++) {
            if(!books.get(i).getCheckedOut()) {
                responce += (i+1) +". "+ books.get(i).bookInfo() + "\n";
            }
        }

        return responce;
    }
}
