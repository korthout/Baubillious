package nl.korthout.baubillious.brain;

import nl.korthout.baubillious.brain.graph.Node;

public class Sensor extends Node {

    protected static final int POWER = 50;

    private final Stimulable stimulable;

    public Sensor(Stimulable stimulable) {
        this.stimulable = stimulable;
    }

    public void sense() {
        if (stimulable.isStimulated()) {
            super.activate(POWER);
        }
    }
}
