package Commands;

import Collection.*;

import java.lang.reflect.Field;

import static Utilities.Runner.scriptScanner;
import static Utilities.UserInputGetter.*;

public class Update implements Command{

    @Override
    public void execute(String args) {
        int counter = 0;
        for (Movie movie : movies) {
            if (args.isEmpty()) {
                System.out.println("Команда update требует аргументы");
                break;
            } else {
                if (movie.getId() == Integer.parseInt(args)) {
                    try {
                        Field fieldName = movie.getClass().getDeclaredField("name");
                        fieldName.setAccessible(true);
                        fieldName.set(movie, getNameInput());

                        Field fieldX = movie.getCoordinates().getClass().getDeclaredField("x");
                        fieldX.setAccessible(true);
                        fieldX.set(movie.getCoordinates(), getXInput());

                        Field fieldY = movie.getCoordinates().getClass().getDeclaredField("y");
                        fieldY.setAccessible(true);
                        fieldY.set(movie.getCoordinates(), getYInput());

                        Field fieldOscarsCount = movie.getClass().getDeclaredField("oscarsCount");
                        fieldOscarsCount.setAccessible(true);
                        fieldOscarsCount.set(movie, getOscarsCountInput());

                        Field fieldBudget = movie.getClass().getDeclaredField("budget");
                        fieldBudget.setAccessible(true);
                        fieldBudget.set(movie, getBudgetInput());

                        Field fieldLength = movie.getClass().getDeclaredField("length");
                        fieldLength.setAccessible(true);
                        fieldLength.set(movie, getLengthInput());

                        Field fieldMpaaRating = movie.getClass().getDeclaredField("mpaaRating");
                        fieldMpaaRating.setAccessible(true);
                        fieldMpaaRating.set(movie, getMpaaRatingInput());

                        Field fieldPersonName = movie.getOperator().getClass().getDeclaredField("name");
                        fieldPersonName.setAccessible(true);
                        fieldPersonName.set(movie.getOperator(), getPersonNameInput());

                        Field fieldPassportID = movie.getOperator().getClass().getDeclaredField("passportID");
                        fieldPassportID.setAccessible(true);
                        fieldPassportID.set(movie.getOperator(), getPassportIDInput());

                        Field fieldHairColor = movie.getOperator().getClass().getDeclaredField("hairColor");
                        fieldHairColor.setAccessible(true);
                        fieldHairColor.set(movie.getOperator(), getHairColorInput());
                        counter++;
                    } catch (NoSuchFieldException | IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }
                if (!args.isEmpty()) {
                    if (counter == 0) System.out.println("Movie с таким id не существует");
                    else System.out.println("Movie успешно обновлён");
                }
            }
        }
    }
    public void executeInScript(String args) {

        if (args.isEmpty()) {
            System.out.println("Команда update требует аргументы");
        } else {
            int counter = 0;
            for (Movie movie: movies) {
                if (movie.getId() == Integer.parseInt(args)) {
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
                    if (name.isEmpty()) {
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
                    if (personName.isEmpty()) {
                        System.out.println("Имя оператора не может быть пустым");
                        errors++;
                    }
                    if (passportID.isEmpty()) {
                        System.out.println("ИД паспорта не может быть пустым");
                        errors++;
                    }
                    if (errors == 0) {
                        try {
                            Field fieldName = movie.getClass().getDeclaredField("name");
                            fieldName.setAccessible(true);
                            fieldName.set(movie, name);

                            Field fieldX = movie.getCoordinates().getClass().getDeclaredField("x");
                            fieldX.setAccessible(true);
                            fieldX.set(movie.getCoordinates(), x);

                            Field fieldY = movie.getCoordinates().getClass().getDeclaredField("y");
                            fieldY.setAccessible(true);
                            fieldY.set(movie.getCoordinates(), y);

                            Field fieldOscarsCount = movie.getClass().getDeclaredField("oscarsCount");
                            fieldOscarsCount.setAccessible(true);
                            fieldOscarsCount.set(movie, oscarsCount);

                            Field fieldBudget = movie.getClass().getDeclaredField("budget");
                            fieldBudget.setAccessible(true);
                            fieldBudget.set(movie, budget);

                            Field fieldLength = movie.getClass().getDeclaredField("length");
                            fieldLength.setAccessible(true);
                            fieldLength.set(movie, length);

                            Field fieldMpaaRating = movie.getClass().getDeclaredField("mpaaRating");
                            fieldMpaaRating.setAccessible(true);
                            fieldMpaaRating.set(movie, mpaaRating);

                            Field fieldPersonName = movie.getOperator().getClass().getDeclaredField("name");
                            fieldPersonName.setAccessible(true);
                            fieldPersonName.set(movie.getOperator(), personName);

                            Field fieldPassportID = movie.getOperator().getClass().getDeclaredField("passportID");
                            fieldPassportID.setAccessible(true);
                            fieldPassportID.set(movie.getOperator(), passportID);

                            Field fieldHairColor = movie.getOperator().getClass().getDeclaredField("hairColor");
                            fieldHairColor.setAccessible(true);
                            fieldHairColor.set(movie.getOperator(), hairColor);
                            counter++;
                            break;
                        } catch (NoSuchFieldException | IllegalAccessException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
            if (counter == 0) System.out.println("Movie с таким id не существует");
            else System.out.println("Movie успешно обновлён");
        }


    }

    @Override
    public String getName() {
        return "update";
    }
}
