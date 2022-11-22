package org.example.CSVReader;

import java.util.List;

import org.example.CSVReader.exceptions.ColumnNumberMismatchException;

public interface CSVReaderInterface extends AutoCloseable {

    /**
     * Check if the file has next line to read
     */
    public boolean hasNext();

    /**
     * @return Returns the recorded line in List of Strings, splitted by the user defined delimiter.
     * @throws ColumnNumberMismatchException When the entered column number is not
     *                                       equal to column numbers in the scanned
     *                                       file.
     */
    public List<String> getNext() throws ColumnNumberMismatchException;

    /**
     * Get index number of current line.
     */
    public long getCurrentLineIndex();

    /**
     * @param skippedLines Which line number to be skipped.
     * @return Skipped line number.
     */
    public long skipLine(long skippedLines);
}