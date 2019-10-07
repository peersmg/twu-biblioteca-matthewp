package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
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
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        IOHandler inputOutput = new IOHandler(new ByteArrayInputStream("3".getBytes()), output);

        // When
        int response = inputOutput.requestInt("Test message");

        // Then
        assertThat(response, is(3));
    }

    @Test
    public void canRequestString()
    {
        // Given
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        IOHandler inputOutput = new IOHandler(new ByteArrayInputStream("hello".getBytes()), output);

        // When
        int response = inputOutput.requestString("Test message");

        // Then
        assertThat(response, is("hello"));
    }

    @Test
    public void intRequestFailsWithString()
    {
        // Given
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        IOHandler inputOutput = new IOHandler(new ByteArrayInputStream("Invalid Text".getBytes()), output);

        // When
        int response = inputOutput.requestInt("Test message");

        // Then
        assertThat(response, is(-1));
    }

    @Test
    public void canPrintMessage()
    {
        // Given
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        IOHandler inputOutput = new IOHandler(new ByteArrayInputStream("".getBytes()), output);

        // When
        inputOutput.printMessage("ShouldPrint");

        // Then
        assertThat(output.toString(), containsString("ShouldPrint"));
    }
}
