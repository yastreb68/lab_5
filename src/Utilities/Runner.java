package Utilities;

import Collection.Movie;
import Commands.Command;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;


public class Runner {

    public static Scanner scriptScanner = null;
    private static ArrayList<Movie> movies = new ArrayList<>();
    private static LocalDateTime initializationDate = LocalDateTime.now();
    private static String csvPath = System.getenv("CSV");

    public static String getCsvPath() {
        return csvPath;
    }

    public static ArrayList<Movie> getMovies() {
        return movies;
    }

    public static LocalDateTime getInitializationDate() {
        return initializationDate;
    }


    public Runner() throws IOException {
        Invoker.invoke();

        try {
            CSVConverter.CSVToArrayList(movies, csvPath);
        } catch (RuntimeException e) {
            System.out.println("Ошибка при загрузке коллекции");
            System.exit(0);
        }
    }
    public void run() {
        Scanner scanner = new Scanner(System.in);
        Map<String, Command> commands = Invoker.getCommands();

        System.out.println("Добро пожаловать! Введите \"help\" для получения информации по всем доступным командам");

        while (true) {

            System.out.print(">>> ");
            String[] input = scanner.nextLine().trim().split(" ");

            String userCommand = input[0];
            String userArgs = "";
            if (input.length == 2) userArgs = input[1];
            if (commands.containsKey(userCommand)) {
                commands.get(userCommand).execute(userArgs);
            } else {
                System.out.println("Команды " + userCommand + " не существует.");
            }
            System.out.println();
        }
    }


}
