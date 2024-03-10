package Commands;

public class Exit implements Command{

    @Override
    public void execute(String args) {
        System.out.println("До свидания!");
        System.exit(0);
    }

    @Override
    public String getName() {
        return "exit";
    }

}
