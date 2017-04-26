package nl.korthout.baubillious.brain;

import nl.korthout.baubillious.brain.graph.Node;

public class Actuator extends Node {

    private final Actor actor;

    public Actuator(Actor actor) {
        this.actor = actor;
    }

    @Override
    public void activate(int power) {
        if (power > 0) {
            actor.act();
        }
    }
}
