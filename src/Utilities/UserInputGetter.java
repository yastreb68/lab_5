package Utilities;

import Collection.*;


import java.util.Scanner;

public class UserInputGetter {
    static Scanner in = new Scanner(System.in);
    public static Movie getMovieInput()  {
        String name = getNameInput();
        Coordinates coordinates = getCoordinatesInput();
        int oscarsCount = getOscarsCountInput();
        double budget = getBudgetInput();
        Long length = getLengthInput();
        MpaaRating mpaaRating = getMpaaRatingInput();
        Person operator = getPersonInput();
        System.out.println("Movie успешно добавлен");
        return new Movie(name, coordinates, oscarsCount, budget, length, mpaaRating, operator);

    }
    public static String getNameInput() {
        String name = null;
        do {
            System.out.print("Введите имя: ");
            try {
                name = in.nextLine();
                if (name.isEmpty()) {
                    System.out.println("Имя не может быть пустым, повторите ввод");
                    name = null;
                }
            } catch (Exception e)  {
                System.out.println("Убедитесь в правильности введенных данных и повторите ввод. Ошибка: " + e.getMessage());
            }
        } while (name == null);
        return name;
    }

    public static Float getXInput() {
        Float x = null;
        do {
            System.out.print("Введите координату X (число должно быть больше -625): ");
            try {
                x = Float.parseFloat(in.nextLine());
                if (x <= -625) {
                    System.out.println("X должен быть больше -625, повторите ввод");
                    x = null;
                }
            } catch (Exception e) {
                System.out.println("Убедитесь в правильности введенных данных и повторите ввод. Ошибка: " + e.getMessage());
            }
        } while (x == null);
        return x;
    }

    public static Float getYInput() {
        float y = 210;
        do {
            System.out.print("Введите координату Y (число должно быть меньше 209): ");
            try {
                y = Float.parseFloat(in.nextLine());
                if (y >= 209) {
                    System.out.println("Y должен быть меньше 209, повторите ввод");
                    y = 210;
                }
            } catch (Exception e)  {
                System.out.println("Убедитесь в правильности введенных данных и повторите ввод. Ошибка: " + e.getMessage());
            }
        } while (y == 210);
        return y;
    }
    public static Coordinates getCoordinatesInput() {
        Float x = getXInput();
        float y = getYInput();
        return new Coordinates(x, y);
    }
    public static MpaaRating getMpaaRatingInput() {

        MpaaRating mpaaRating = null;
        do {
            System.out.print("Введите MpaaRating(G, PG, PG_13, R): ");
            try {
                mpaaRating = MpaaRating.valueOf(in.nextLine());
            } catch (RuntimeException e)  {
                System.out.println("Убедитесь в правильности введенных данных и повторите ввод. Ошибка: " + e.getMessage());
            }
        } while (mpaaRating == null);
        return mpaaRating;
    }

    public static double getBudgetInput() {

        double budget = -1;
        do {
            System.out.print("Введите бюджет (число должно быть больше 0): ");
            try {
                budget = Double.parseDouble(in.nextLine());
                if (budget <= 0) {
                    System.out.println("Бюджет должен быть больше 0, повторите ввод");
                    budget = -1;
                }
            } catch (Exception e)  {
                System.out.println("Убедитесь в правильности введенных данных и повторите ввод. Ошибка: " + e.getMessage());
            }
        } while (budget == -1);
        return budget;
    }

    public static int getOscarsCountInput() {

        int oscarsCount = -1;
        do {
            System.out.print("Введите количество оскаров (число должно быть больше 0): ");
            try {
                oscarsCount = Integer.parseInt(in.nextLine());
                if (oscarsCount <= 0) {
                    System.out.println("Количество оскаров должен быть больше 0, повторите ввод");
                    oscarsCount = -1;
                }
            } catch (Exception e)  {
                System.out.println("Убедитесь в правильности введенных данных и повторите ввод. Ошибка: " + e.getMessage());
            }
        } while (oscarsCount == -1);
        return oscarsCount;
    }

    public static Long getLengthInput() {

        Long length = null;
        do {
            System.out.print("Введите длину (число должно быть больше 0): ");
            try {
                length = Long.parseLong(in.nextLine());
                if (length <= 0) {
                    System.out.println("Длина должна быть больше 0, повторите ввод");
                    length = null;
                }
            } catch (Exception e)  {
                System.out.println("Убедитесь в правильности введенных данных и повторите ввод. Ошибка: " + e.getMessage());
            }
        } while (length == -1);
        return length;
    }

    public static String getPersonNameInput() {
        String name = null;
        do {
            System.out.print("Введите имя оператора: ");
            try {
                name = in.nextLine();
                if (name.isEmpty()) {
                    System.out.println("Имя оператора не может быть пустым, повторите ввод");
                    name = null;
                }
            } catch (Exception e)  {
                System.out.println("Убедитесь в правильности введенных данных и повторите ввод. Ошибка: " + e.getMessage());
            }
        } while (name == null);
        return name;
    }
    public static String getPassportIDInput() {
        String passportID = null;
        do {
            System.out.print("Введите ИД паспорта: ");
            try {
                passportID = in.nextLine();
                if (passportID.isEmpty()) {
                    System.out.println("ИД паспорта не может быть пустым, повторите ввод");
                    passportID = null;
                }
            } catch (Exception e)  {
                System.out.println("Убедитесь в правильности введенных данных и повторите ввод. Ошибка: " + e.getMessage());
            }
        } while (passportID == null);
        return passportID;
    }
    public static Color getHairColorInput() {
        Color hairColor = null;
        do {
            System.out.print("Введите цвет волос(GREEN, RED, BLUE): ");
            try {
                hairColor = Color.valueOf(in.nextLine());
            } catch (Exception e)  {
                System.out.println("Убедитесь в правильности введенных данных и повторите ввод. Ошибка: " + e.getMessage());
            }
        } while (hairColor == null);
        return hairColor;
    }

    public static Person getPersonInput() {

        String name = getPersonNameInput();
        String passportID = getPassportIDInput();
        Color hairColor = getHairColorInput();
        return new Person(name, passportID, hairColor);
    }

}
