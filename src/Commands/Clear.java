package Commands;


import Utilities.Runner;

public class Clear implements Command{
    @Override
    public void execute(String args) {
        movies.clear();
        System.out.println("Коллекция успешно очищена");
    }

    @Override
    public String getName() {
        return "clear";
    }
}
