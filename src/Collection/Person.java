package Collection;

import java.util.Objects;

public class Person {
    private final String name; //Поле не может быть null, Строка не может быть пустой
    private final String passportID; //Поле не может быть null
    private final Color hairColor; //Поле может быть null

    public Person(String name, String passportID, String hairColor) {
        this.name = name;
        this.passportID = passportID;
        this.hairColor = Color.valueOf(hairColor);
    }

    public Person(String name, String passportID, Color hairColor) {
        this.name = name;
        this.passportID = passportID;
        this.hairColor = hairColor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) && Objects.equals(passportID, person.passportID) && hairColor == person.hairColor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, passportID, hairColor);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", passportID='" + passportID + '\'' +
                ", hairColor=" + hairColor +
                '}';
    }

    public Color getHairColor() {
        return hairColor;
    }

    public String getPassportID() {
        return passportID;
    }

    public String getName() {
        return name;
    }
}

