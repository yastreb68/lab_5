package Commands;

import Utilities.CSVConverter;
import Utilities.Runner;

import java.io.IOException;

public class Save implements Command{
    @Override
    public void execute(String args) {
        try {
            CSVConverter.ArrayListToCSV(movies, Runner.getCsvPath());
            System.out.println("Коллекция успешно сохранена");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getName() {
        return "save";
    }
}
