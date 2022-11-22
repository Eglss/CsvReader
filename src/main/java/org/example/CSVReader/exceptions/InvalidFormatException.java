package org.example.CSVReader.exceptions;

public class InvalidFormatException extends Exception {

    public InvalidFormatException() {
        super("Invalid format of the file.");
    }
}
