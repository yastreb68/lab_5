package Commands;

public class RemoveFirst implements Command{
    @Override
    public void execute(String args) {

        if (!movies.isEmpty()) {
            movies.remove(0);
            System.out.println("Первый элемент коллекции успешно удалён");
        } else System.out.println("Невозможно удалить первый элемент коллекции, так ка она пустая");
    }

    @Override
    public String getName() {
        return "remove_first";
    }
}
