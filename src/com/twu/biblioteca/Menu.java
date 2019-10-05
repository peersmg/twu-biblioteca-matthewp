package com.twu.biblioteca;

public class Menu {
    ItemStorage itemStorage;
    boolean applicationRunning = true;
    IOHandler inputOutput;

    public Menu(ItemStorage itemStorage, IOHandler inputOutput) {
        this.itemStorage = itemStorage;
        this.inputOutput = inputOutput;
        welcomeMessage();
    }

    public void runInputListener(){
        while (applicationRunning){
            getUserSelection();
        }
    }

    public void setBooks(ItemStorage itemStorage) {
        this.itemStorage = itemStorage;
    }

    public void setApplicationRunning(boolean applicationRunning) {
        this.applicationRunning = applicationRunning;
    }

    private void getUserSelection(){

        inputOutput.printMessage("Options: Exit Application [0] | Show Available Books [1] | Check out book [2] | Show checked out books [3] | Return a book [4]");

        int selection = inputOutput.requestInt("Please enter selection: ");

        inputOutput.printMessage(actOnSelection(selection));
    }

    private String checkoutBook()
    {
        String response;

        int selection = inputOutput.requestInt("Please enter book ID to checkout or 0 to cancel: ");

        if(selection == 0){
            return "Cancelling checkout.";
        }

        boolean result = itemStorage.checkoutItem(selection);

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

        int selection = inputOutput.requestInt("Please enter book ID to return or 0 to cancel: ");

        if(selection == 0){
            return "Cancelling return.";
        }

        boolean result = itemStorage.returnItem(selection);

        return result ? "Thank you for returning the book" : "That is not a valid book to return.";
    }


    public String actOnSelection(int selection)
    {
        String response;
        switch (selection){
            case 1:
                response = String.join("\n", itemStorage.printAvailableItems());
                break;
            case 2:
                response = checkoutBook();
                break;
            case 3:
                response = itemStorage.printCheckedOutItems();
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
        inputOutput.printMessage("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }
}
