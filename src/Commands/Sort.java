package Commands;

import java.util.Collections;

public class Sort implements Command{
    @Override
    public void execute(String args) {
        Collections.sort(movies);
        System.out.println("Коллекция успешно отсортирована");
    }

    @Override
    public String getName() {
        return "sort";
    }
}
