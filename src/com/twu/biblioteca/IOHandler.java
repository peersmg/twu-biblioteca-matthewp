package com.twu.biblioteca;


import java.io.PrintWriter;
import java.util.Scanner;

public class IOHandler {

    Scanner scanner;
    PrintWriter output;

    public IOHandler(Scanner scanner, PrintWriter output) {
        this.scanner = scanner;
        this.output = output;
    }

    public int requestInt(String message) {

        output.println(message);
        String input = scanner.next();

        try {
            return Integer.parseInt(input);
        }
        catch (NumberFormatException nfe)
        {
            return -1;
        }
    }

    public void printMessage(String message)
    {
        output.println(message);
    }
}
