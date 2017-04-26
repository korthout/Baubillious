package nl.korthout.example.sensors;


import nl.korthout.baubillious.brain.Stimulable;
import nl.korthout.example.Location;
import nl.korthout.example.Player;

public class StandStillChecker implements Stimulable {

    private final Player player;
    private Location lastKnownLocation;
    private boolean stoodStill;

    public StandStillChecker(Player player) {
        this.player = player;
        this.lastKnownLocation = player.getLocation();
    }

    public void checkStoodStill() {
        Location location = player.getLocation();
        if (lastKnownLocation.equal(location)) {
            stoodStill = true;
        }
        lastKnownLocation = location;
    }

    @Override
    public boolean isStimulated() {
        if (stoodStill) {
            stoodStill = false;
            return true;
        }
        return false;
    }
}
