package Utilities;

import Collection.Coordinates;
import Collection.Movie;
import Collection.Person;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.util.ArrayList;


public class  CSVConverter {
    private static final CSVFormat format = CSVFormat.Builder.create(CSVFormat.DEFAULT).setHeader("id", "name", "x", "y", "creation date", "oscars", "budget", "length", "mpaa rating", "person's name", "passportID", "hair color").build();

    public static void ArrayListToCSV(ArrayList<Movie> movies, String filePath) throws IOException {
        try (PrintWriter fileWriter = new PrintWriter(new FileWriter(filePath));
             CSVPrinter csvPrinter = new CSVPrinter(fileWriter, format)) {

            for (Movie movie : movies) {
                csvPrinter.printRecord(movie.getId(),
                        movie.getName(),
                        movie.getCoordinates().getX(),
                        movie.getCoordinates().getY(),
                        movie.getCreationDate(),
                        movie.getOscarsCount(),
                        movie.getBudget(),
                        movie.getLength(),
                        movie.getMpaaRating(),
                        movie.getOperator().getName(),
                        movie.getOperator().getPassportID(),
                        movie.getOperator().getHairColor());
            }
        }
    }

    public static void CSVToArrayList(ArrayList<Movie> movies, String filePath) throws IOException {


        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filePath))) {
            InputStreamReader reader = new InputStreamReader(bis);
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader());

            int counter = 1;
            for (CSVRecord record : csvParser) {
                int id = Integer.parseInt(record.get("id"));
                String name = record.get("name");
                Float x = Float.parseFloat(record.get("x"));
                float y = Float.parseFloat(record.get("y"));
                String creationDate = record.get("creation date");
                int oscarsCount = Integer.parseInt(record.get("oscars"));
                double budget = Double.parseDouble(record.get("budget"));
                Long length = Long.parseLong(record.get("length"));
                String mpaaRating = record.get("mpaa rating");
                String personName = record.get("person's name");
                String passportID = record.get("passportID");
                String hairColor = record.get("hair color");

                Movie movie = new Movie(id, name, new Coordinates(x, y), creationDate, oscarsCount, budget, length, mpaaRating, new Person(personName, passportID, hairColor));
                if (!movie.checkMovie()) {
                    movies.add(movie);
                } else {
                    System.out.println("Не удалось загрузить Movie " + counter++ + ". Проверьте валидность данных в файле");
                }


            }

        }


    }
}