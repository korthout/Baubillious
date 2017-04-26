package nl.korthout.example;

public class Location {

    private static final int MAX_X = 50;
    private static final int MAX_Y = 50;
    private int x;
    private int y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean equal(Location other) {
        return stepsTo(other) == 0;
    }

    public int stepsTo(Location other) {
        int horizontalSteps = Math.abs(x - other.x);
        int verticalSteps = Math.abs(y - other.y);
        return horizontalSteps + verticalSteps;
    }

    public void moveNorth() {
        if (y > 0) {
            printLocation();
            y--;
        }
    }

    public void moveEast() {
        if (x < MAX_X) {
            printLocation();
            x++;
        }
    }

    public void moveSouth() {
        if (y < MAX_Y) {
            printLocation();
            y++;
        }
    }

    public void moveWest() {
        if (x > 0) {
            printLocation();
            x--;
        }
    }

    public void printLocation() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}