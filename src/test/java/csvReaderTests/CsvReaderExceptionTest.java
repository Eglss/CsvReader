package csvReaderTests;

import org.example.CSVReader.CSVReader;
import org.example.CSVReader.exceptions.ColumnNumberMismatchException;
import org.example.CSVReader.exceptions.InvalidFormatException;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CsvReaderExceptionTest {

    @Test
    public void testInvalidFormatException() {
        String filePath = "E:\\DXC\\cvs2db\\csv2dbIntelliJ\\csv2db\\src\\main\\resources\\testCSV.csv";
        assertThrows(InvalidFormatException.class, () -> new CSVReader(filePath, ",", 3));
    }

    @Test
    public void testInvalidColumnNumberMismatchException() {
        String filePath = "E:\\DXC\\cvs2db\\csv2dbIntelliJ\\csv2db\\src\\main\\resources\\testCSV.csv";
        assertThrows(ColumnNumberMismatchException.class, () -> new CSVReader(filePath, ",", 4));
    }

    @Test
    public void testFileNotFoundException() {
        String filePath = "E:\\DXC\\cvs2db\\csv2dbIntelliJ\\csv2db\\src\\main\\resources\\fileNotFound.csv";
        assertThrows(FileNotFoundException.class, () -> new CSVReader(filePath, ",", 3));
    }

}
