package com.twu.biblioteca;


import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class IOHandler {

    public IOHandler(InputStream scannerStream, OutputStream outputStream) {

        System.setOut(new PrintStream(outputStream));
        System.setIn(scannerStream);
    }

    public int requestInt(String message) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(message);

        String input = scanner.next();

        try {
            return Integer.parseInt(input);
        }
        catch (NumberFormatException nfe)
        {
            return -1;
        }
    }

    public String requestString(String message) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(message);

        return scanner.next();
    }

    public void printMessage(String message)
    {
        System.out.println(message);
    }
}
