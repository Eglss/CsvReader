import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.example.CSVReader.exceptions.ColumnNumberMismatchException;
import org.example.CSVReader.exceptions.InvalidFormatException;
import org.example.CSVReader.CSVReader;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws ColumnNumberMismatchException, FileNotFoundException, InvalidFormatException {
        Logger logger = (Logger) LogManager.getLogger(CSVReader.class);
        CSVReader csvReader = new CSVReader("E:\\DXC\\cvs2db\\csv2dbIntelliJ\\csv2db\\src\\main\\resources\\testCSV.csv", ",", 4);
    }
}

