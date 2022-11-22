package csvReaderTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.example.CSVReader.CSVReader;
import org.example.CSVReader.exceptions.InvalidFormatException;
import org.junit.jupiter.api.Test;

import org.example.CSVReader.exceptions.ColumnNumberMismatchException;

public class CsvReaderMethodTests {

    @Test
    public void testHasNext() {
        String filePath = "E:\\DXC\\cvs2db\\csv2dbIntelliJ\\csv2db\\src\\main\\resources\\testCSV.csv";
        CSVReader csvreader = null;
        try {
            csvreader = new CSVReader(filePath, ",", 18);
        } catch (FileNotFoundException | ColumnNumberMismatchException | InvalidFormatException e) {

            e.printStackTrace();
        }
        assertTrue(csvreader.hasNext());
    }

    @Test
    public void testGetNext() {
        String filePath = "E:\\DXC\\cvs2db\\csv2dbIntelliJ\\csv2db\\src\\main\\resources\\testCSV.csv";

        String[] rows = new String[3];
        rows[0] = "mercedes";
        rows[1] = "clasa";
        rows[2] = "9";
        List<String> test1 = new ArrayList<String>();
        test1.add(rows[0]);
        test1.add(rows[1]);
        test1.add(rows[2]);

        CSVReader csvreader = null;
        try {
            csvreader = new CSVReader(filePath, ",", 3);
        } catch (FileNotFoundException | ColumnNumberMismatchException | InvalidFormatException e) {
            e.printStackTrace();
        }

        try {
            assertEquals(test1, csvreader.getNext());
        } catch (ColumnNumberMismatchException e) {
            e.printStackTrace();
        }
    }
}
