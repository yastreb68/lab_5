package Commands;

import Collection.Movie;

public class FilterStartsWithName implements Command{


    @Override
    public void execute(String args) {

        if (args.isEmpty()) {
            System.out.println("Команда filter_starts_with_name требует аргументы");
        } else {
            int counter = 0;
            for (Movie movie: movies) {
                if (movie.getName().startsWith(args)) {
                    counter++;
                    System.out.println(movie);
                }
            }
            if (counter == 0) System.out.println("Movie с полями name, начинающимися на " + args + ", нет");
        }
    }

    @Override
    public String getName() {
        return "filter_starts_with_name";
    }
}
