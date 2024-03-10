package Commands;

import Collection.Movie;

public class MaxById implements Command{
    @Override
    public void execute(String args) {
        int maxId = movies.get(0).getId();
        Movie maxMovie = movies.get(0);
        for (Movie movie: movies) {
            if (movie.getId() > maxId) {
                maxId = movie.getId();
                maxMovie = movie;
            }
        }
        System.out.println("Movie с максимальным id:" + "\n" + maxMovie);
    }

    @Override
    public String getName() {
        return "max_by_id";
    }
}
