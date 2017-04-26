package nl.korthout.example;

import java.util.Observable;

public class Health extends Observable {

    private final int maxHealth;
    private int health;

    public Health(int maxHealth) {
        this.maxHealth = maxHealth;
        this.health = maxHealth;
    }

    public void decreaseHealth() {
        health--;
        System.out.println("Player is getting a bit more hungry. Health: " + health);
        setChanged();
        notifyObservers();
    }

    public boolean alive() {
        return health > 0;
    }

    public void increaseHealth(int nutrition) {
        health += nutrition;
    }
}
