package Commands;

import Utilities.Runner;


public class Info implements Command{
    @Override
    public void execute(String args) {
        System.out.println("Информация о коллекции:");
        System.out.println("Тип коллекции: " + Runner.getMovies().getClass().getSimpleName());
        System.out.println("Дата инициализации: " + Runner.getInitializationDate());
        System.out.println("Количество элементов: " + Runner.getMovies().size());

    }
    @Override
    public String getName() {
        return "info";
    }
}
