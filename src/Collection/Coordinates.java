package Collection;



public class Coordinates {
    private Float x; //Значение поля должно быть больше -625, Поле не может быть null
    private float y; //Максимальное значение поля: 209


    public Coordinates(Float x, float y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return x + ";" + y;
    }

    public Float getX() {
        return x;
    }

    public float getY() {
        return y;
    }







}
