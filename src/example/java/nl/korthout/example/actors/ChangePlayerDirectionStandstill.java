package nl.korthout.example.actors;

import nl.korthout.baubillious.brain.Actor;
import nl.korthout.example.Direction;
import nl.korthout.example.Player;

public class ChangePlayerDirectionStandstill implements Actor {

    private final Player player;

    public ChangePlayerDirectionStandstill(Player player) {
        this.player = player;
    }

    @Override
    public void act() {
        player.changeDirection(Direction.STANDSTILL);
    }
}
