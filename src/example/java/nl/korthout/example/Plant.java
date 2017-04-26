package nl.korthout.example;

public class Plant extends GameObject {

    private int nutrition;

    public Plant(int x, int y, int nutrition) {
        super(new Location(x, y));
        this.nutrition = nutrition;
    }

    public int getNutrition() {
        return nutrition;
    }

}
