package org.example.CSVReader;

import org.example.CSVReader.exceptions.ColumnNumberMismatchException;
import org.example.CSVReader.exceptions.InvalidFormatException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CSVReader implements CSVReaderInterface {
    private Logger logger = (Logger) LogManager.getLogger(CSVReader.class);
    private final String advancedDelimiter = "(?=([^\"]*\"[^\"]*\")*[^\"]*$)";
    private final String userDelimiter;
    private final int numberOfColumns;
    private Scanner scan = null;
    private long lineCounter;

    public CSVReader(String filePath, String delimiter, int numberOfColumns) throws InvalidFormatException, FileNotFoundException, ColumnNumberMismatchException {
        this.numberOfColumns = numberOfColumns;
        userDelimiter = delimiter + advancedDelimiter;
        logger.trace("Error logged");

        String csvValidation = filePath.substring(filePath.length() - 4);
        if (!csvValidation.equals(".csv")) {
            throw new InvalidFormatException();
        }

        lineCounter = 0;
        File fileName = new File(filePath);
        this.scan = new Scanner(fileName);
        String[] rows = scan.nextLine().split(userDelimiter);
        if (rows.length != numberOfColumns) {
            throw new ColumnNumberMismatchException();
        }
    }

    @Override
    public boolean hasNext() {
        return scan.hasNextLine();
    }

    @Override
    public List<String> getNext() throws ColumnNumberMismatchException {
        List<String> recordLine = new ArrayList<>();
        String value = scan.nextLine();
        lineCounter++;
        recordLine = Arrays.asList(value.split(userDelimiter));

        if (recordLine.size() != numberOfColumns) {
            throw new ColumnNumberMismatchException();
        }
        return recordLine;
    }

    @Override
    public long getCurrentLineIndex() {
        return lineCounter;
    }

    @Override
    public long skipLine(long skippedLines) {
        for (long i = 0; i < skippedLines; i++) {
            if (scan.hasNextLine()) scan.nextLine();
            else return (i);
        }
        return skippedLines;
    }

    @Override
    public void close() throws Exception {
        // need to fix
        try (CSVReader reader = new CSVReader(userDelimiter, userDelimiter, numberOfColumns)) {
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (scan != null) {
                scan.close();
            }
        }
    }
}