package Commands;

import Collection.Movie;
import Utilities.Runner;


public class Show implements Command{
    @Override
    public void execute(String args) {
        for (Movie movie: movies) {
            System.out.println(movie);
        }
//        for (Movie movie : movies) {
//            System.out.printf("| %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s",
//                    movie.getId(), movie.getName(), movie.getCoordinates().getX(), movie.getCoordinates().getY(),
//                    movie.getOscarsCount(), movie.getBudget(), movie.getLength(), movie.getMpaaRating(),
//                    movie.getOperator().getName(), movie.getOperator().getPassportID(), movie.getOperator().getHairColor());
//        }

    }

    @Override
    public String getName() {
        return "show";
    }
}
