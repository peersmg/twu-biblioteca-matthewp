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

        return scanner.nextInt();
    }

    public void printMessage(String message)
    {

    }
}
