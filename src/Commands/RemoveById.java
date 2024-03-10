package Commands;

import Collection.Movie;
import Utilities.Runner;


public class RemoveById implements Command{


    public void execute(String args) {

        if (args.isEmpty()) {
            System.out.println("Команда remove_by_id требует аргументы");
        } else {
            int counter = 0;
            for (Movie movie: movies) {
                if (movie.getId() == Integer.parseInt(args)) {
                    movies.remove(movie);
                    counter++;
                }
                break;
            }
            if (counter == 0) System.out.println("Movie с таким id не существует");
            else System.out.println("Movie с таким id успешно удалён");
        }
    }

    @Override
    public String getName() {
        return "remove_by_id";
    }
}
