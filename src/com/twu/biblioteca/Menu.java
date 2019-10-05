package com.twu.biblioteca;

public class Menu {
    ItemStorage bookStorage;
    ItemStorage movieStorage;
    boolean applicationRunning = true;
    IOHandler inputOutput;

    public Menu(ItemStorage bookStorage, ItemStorage movieStorage, IOHandler inputOutput) {
        this.bookStorage = bookStorage;
        this.movieStorage = movieStorage;
        this.inputOutput = inputOutput;
        welcomeMessage();
    }

    public void runInputListener(){
        while (applicationRunning){
            getUserSelection();
        }
    }

    public void setBooks(ItemStorage itemStorage) {
        this.bookStorage = itemStorage;
    }

    public void setMovies(ItemStorage movieStorage) {
        this.movieStorage = movieStorage;
    }

    public void setApplicationRunning(boolean applicationRunning) {
        this.applicationRunning = applicationRunning;
    }

    private void getUserSelection(){

        inputOutput.printMessage("Options: Show Available Books [1] | Check out book [2] | Show checked out books [3] | Return a book [4]\n" +
                "Show Available Movies [5] | Checkout Movie [6] | Exit Application [0]");

        int selection = inputOutput.requestInt("Please enter selection: ");

        inputOutput.printMessage(actOnSelection(selection));
    }

    public String checkoutItem(ItemStorage itemStore, String itemType)
    {
        String response;

        int selection = inputOutput.requestInt("Please enter "+itemType+" ID to checkout or 0 to cancel: ");

        if(selection == 0){
            return "Cancelling checkout.";
        }

        boolean result = itemStore.checkoutItem(selection);

        if(!result){
            response = "Sorry, that "+itemType+" is not available. Please enter a valid book ID!";
        }
        else {
            response = "Thank you! Enjoy the "+itemType;
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

        boolean result = bookStorage.returnItem(selection);

        return result ? "Thank you for returning the book" : "That is not a valid book to return.";
    }


    public String actOnSelection(int selection)
    {
        String response;
        switch (selection){
            case 1:
                response = String.join("\n", bookStorage.printAvailableItems());
                break;
            case 2:
                response = checkoutItem(bookStorage, "book");
                break;
            case 3:
                response = bookStorage.printCheckedOutItems();
                break;
            case 4:
                response = returnBook();
                break;
            case 5:
                response = String.join("\n", movieStorage.printAvailableItems());
                break;
            case 6:
                response = checkoutItem(movieStorage, "movie");
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
