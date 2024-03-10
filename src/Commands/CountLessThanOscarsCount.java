package Commands;

import Collection.Movie;

public class CountLessThanOscarsCount implements Command{


    @Override
    public void execute(String args) {
        if (args.isEmpty()) {
            System.out.println("Команда count_less_than_oscars_count требует аргументы");
        } else {
            int oscars = Integer.parseInt(args);
            int counter = 0;
            for (Movie movie: movies) {
                if (movie.getOscarsCount() < oscars) {
                    counter++;
                }
            }
            System.out.println("Количество фильмов, у которых больше " + oscars + " оcкара(ов): " + counter);
        }
    }

    @Override
    public String getName() {
        return "count_less_than_oscars_count";
    }
}
