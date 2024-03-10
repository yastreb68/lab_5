package Commands;



import Collection.*;
import Utilities.UserInputGetter;

import java.util.Scanner;

import static Utilities.Runner.scriptScanner;


public class Add implements Command {
    public void execute(String args) {
        movies.add(UserInputGetter.getMovieInput());
    }

    public void executeInScript(String args) {

        String name = null;
        Float x = null;
        float y = 210;
        int oscarsCount = -1;
        double budget = -1;
        Long length = null;
        MpaaRating mpaaRating = null;
        String personName = null;
        String passportID = null;
        Color hairColor = null;
        try {
            name = scriptScanner.nextLine();
        } catch (RuntimeException e) {
            System.out.println("Ошибка при инициализации имени");
        }
        try {
            x = Float.parseFloat(scriptScanner.nextLine());
        } catch (RuntimeException e) {
            System.out.println("Ошибка при инициализации X");
        }
        try {
            y = Float.parseFloat(scriptScanner.nextLine());
        } catch (RuntimeException e) {
            System.out.println("Ошибка при инициализации Y");
        }
        try {
            oscarsCount = Integer.parseInt(scriptScanner.nextLine());
        } catch (RuntimeException e) {
            System.out.println("Ошибка при инициализации количества оскаров");
        }
        try {
            budget = Double.parseDouble(scriptScanner.nextLine());
        } catch (RuntimeException e) {
            System.out.println("Ошибка при инициализации бюджета");
        }
        try {
            length = Long.valueOf(scriptScanner.nextLine());
        } catch (RuntimeException e) {
            System.out.println("Ошибка при инициализации длины");
        }
        try {
            mpaaRating = MpaaRating.valueOf(scriptScanner.nextLine());
        } catch (RuntimeException e) {
            System.out.println("Ошибка при инициализации mpaa rating");
        }
        try {
            personName = scriptScanner.nextLine();
        } catch (RuntimeException e) {
            System.out.println("Ошибка при инициализации имени оператора");
        }
        try {
            passportID = scriptScanner.nextLine();
        } catch (RuntimeException e) {
            System.out.println("Ошибка при инициализации паспорта");
        }
        try {
            hairColor = Color.valueOf(scriptScanner.nextLine());
        } catch (RuntimeException e) {
            System.out.println("Ошибка при инициализации цвета волос");
        }


        int errors = 0;
        if (name == null) {
            System.out.println("Имя не может быть пустым");
            errors++;
        }
        if (x <= -625) {
            System.out.println("X должен быть больше -625");
            errors++;
        }
        if (y >= 209) {
            System.out.println("Y должен быть меньше 209");
            errors++;
        }
        if (oscarsCount <= 0) {
            System.out.println("Количество оскаров должен быть больше 0");
            errors++;
        }
        if (budget <= 0) {
            System.out.println("Бюджет должен быть больше 0");
            errors++;
        }
        if (length <= 0) {
            System.out.println("Длина должна быть больше 0");
            errors++;
        }
        if (personName == null) {
            System.out.println("Имя оператора не может быть пустым");
            errors++;
        }
        if (passportID == null) {
            System.out.println("ИД паспорта не может быть пустым");
            errors++;
        }

        if (errors == 0) {
            movies.add(new Movie(name, new Coordinates(x, y), oscarsCount, budget, length, mpaaRating, new Person(personName, passportID, hairColor)));
            System.out.println("Movie успешно добавлен");
        }
    }
    @Override
    public String getName() {
        return "add";
    }

}
