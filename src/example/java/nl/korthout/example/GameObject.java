package nl.korthout.example;

import java.util.Observable;

public class GameObject extends Observable {

    protected final Location location;

    public GameObject(Location location) {
        this.location = location;
    }

    public boolean collision(GameObject other) {
        return location.equal(other.location);
    }

    public int stepsTo(GameObject other) {
        return location.stepsTo(other.location);
    }

    public Location getLocation() {
        return location;
    }

}
