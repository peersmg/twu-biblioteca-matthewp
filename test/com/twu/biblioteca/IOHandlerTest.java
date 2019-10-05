package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Scanner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

public class IOHandlerTest {

    @Test
    public void canRequestInteger()
    {
        // Given
        StringWriter output = new StringWriter();
        IOHandler inputOutput = new IOHandler(new Scanner("3"), new PrintWriter(output));

        // When
        int response = inputOutput.requestInt("Test message");

        // Then
        assertThat(response, is(3));
    }

    @Test
    public void intRequestFailsWithString()
    {
        // Given
        StringWriter output = new StringWriter();
        IOHandler inputOutput = new IOHandler(new Scanner("Invalid Text"), new PrintWriter(output));

        // When
        int response = inputOutput.requestInt("Test message");

        // Then
        assertThat(response, is(-1));
    }

    @Test
    public void canPrintMessage()
    {
        // Given
        StringWriter output = new StringWriter();
        IOHandler inputOutput = new IOHandler(new Scanner(""), new PrintWriter(output));

        // When
        inputOutput.printMessage("ShouldPrint");

        // Then
        assertThat(output.toString(), containsString("ShouldPrint"));
    }
}
