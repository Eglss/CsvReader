package org.example.CSVReader.exceptions;

public class ColumnNumberMismatchException extends Exception  {

    public ColumnNumberMismatchException() {
        super("Columns number you have entered does not match with the columns of the file.");
    }
}
