package Commands;

import Collection.Movie;
import Utilities.Runner;

import java.util.ArrayList;

public interface Command {
    void execute(String args);
    String getName();
    ArrayList<Movie> movies = Runner.getMovies();
    
    default void executeInScript(String userArgs) {
    }
}
