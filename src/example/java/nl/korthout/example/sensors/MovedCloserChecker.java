package nl.korthout.example.sensors;

import nl.korthout.baubillious.brain.Stimulable;
import nl.korthout.example.GameObject;
import nl.korthout.example.Location;

public class MovedCloserChecker implements Stimulable {

    private final GameObject gameObject1;
    private final Location locationGameObject2;

    private Location lastKnownLocationGameObject1;
    private boolean movedClosed;

    public MovedCloserChecker(GameObject gameObject1, GameObject gameObject2) {
        this.gameObject1 = gameObject1;
        this.lastKnownLocationGameObject1 = gameObject1.getLocation();
        this.locationGameObject2 = gameObject2.getLocation();
        movedClosed = false;
    }

    public void checkMovedCloser() {
        Location locationGameObject1 = gameObject1.getLocation();
        if (lastKnownSteps() > stepsTo(locationGameObject1)) {
            movedClosed = true;
        }
        lastKnownLocationGameObject1 = locationGameObject1;
    }

    private int stepsTo(Location location) {
        return location.stepsTo(locationGameObject2);
    }

    private int lastKnownSteps() {
        return stepsTo(lastKnownLocationGameObject1);
    }

    @Override
    public boolean isStimulated() {
        if (movedClosed) {
            movedClosed = false;
            return true;
        }
        return false;
    }
}
