package nl.korthout.example;

import nl.korthout.baubillious.brain.Actuator;
import nl.korthout.baubillious.brain.Agent;
import nl.korthout.baubillious.brain.Sensor;
import nl.korthout.baubillious.brain.SensorLooper;
import nl.korthout.example.actors.ChangePlayerDirectionEast;
import nl.korthout.example.actors.ChangePlayerDirectionNorth;
import nl.korthout.example.actors.ChangePlayerDirectionSouth;
import nl.korthout.example.actors.ChangePlayerDirectionStandstill;
import nl.korthout.example.actors.ChangePlayerDirectionWest;
import nl.korthout.example.sensors.MovedCloserChecker;
import nl.korthout.example.sensors.StandStillChecker;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.stream.Collectors;

public class Game {

    private static final int GAME_TICK_LENGTH = 1000 / 30;

    private Timer timer;
    private int ticks;
    private int score;

    private SensorLooper sensorLooper;
    private Agent agent;
    private MovedCloserChecker movedCloserChecker;
    private MovedCloserChecker movedCloserChecker1;
    private MovedCloserChecker movedCloserChecker2;
    private MovedCloserChecker movedCloserChecker3;
    private MovedCloserChecker movedCloserChecker4;
    private MovedCloserChecker movedCloserChecker5;
    private StandStillChecker stoodStillChecker;

    private Player player;

    private List<Plant> plants;
    private Plant plant;
    private Plant plant1;
    private Plant plant2;
    private Plant plant3;
    private Plant plant4;
    private Plant plant5;

    public static void main(String[] args) {
        new Game();
    }

    public Game() {
        player = new Player(this, 25, 25, 10);
        plants = new ArrayList<>();
        plant = new Plant(1, 1, 3);
        plant1 = new Plant(5, 10, 3);
        plant2 = new Plant(9, 7, 3);
        plant3 = new Plant(3, 12, 3);
        plant4 = new Plant(4, 4, 3);
        plant5 = new Plant(10, 8, 3);

        plants.add(plant);
        plants.add(plant1);
        plants.add(plant2);
        plants.add(plant3);
        plants.add(plant4);
        plants.add(plant5);

        createAgent();
        startGame();
        startBrain();
    }

    private void createAgent() {
        List<Sensor> sensors = new ArrayList<>();
        addSensors(sensors);
        List<Actuator> actuators = new ArrayList<>();
        addActuators(player, actuators);
        agent = new Agent(sensors, actuators);
    }

    private void addSensors(List<Sensor> sensors) {
        movedCloserChecker = new MovedCloserChecker(player, plant);
        movedCloserChecker1 = new MovedCloserChecker(player, plant1);
        movedCloserChecker2 = new MovedCloserChecker(player, plant2);
        movedCloserChecker3 = new MovedCloserChecker(player, plant3);
        movedCloserChecker4 = new MovedCloserChecker(player, plant4);
        movedCloserChecker5 = new MovedCloserChecker(player, plant5);
        stoodStillChecker = new StandStillChecker(player);
        sensors.add(new Sensor(movedCloserChecker));
        sensors.add(new Sensor(movedCloserChecker1));
        sensors.add(new Sensor(movedCloserChecker2));
        sensors.add(new Sensor(movedCloserChecker3));
        sensors.add(new Sensor(movedCloserChecker4));
        sensors.add(new Sensor(movedCloserChecker5));
        sensors.add(new Sensor(stoodStillChecker));
    }

    private void addActuators(Player player, List<Actuator> actuators) {
        actuators.add(new Actuator(new ChangePlayerDirectionNorth(player)));
        actuators.add(new Actuator(new ChangePlayerDirectionEast(player)));
        actuators.add(new Actuator(new ChangePlayerDirectionSouth(player)));
        actuators.add(new Actuator(new ChangePlayerDirectionWest(player)));
        actuators.add(new Actuator(new ChangePlayerDirectionStandstill(player)));
    }

    public void startGame() {
        if (player != null) {
            scheduleGameTick();
        }
    }

    private void startBrain() {
        sensorLooper = new SensorLooper(agent);
        sensorLooper.start();
    }

    private void scheduleGameTick() {
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                gameLoop();
            }
        }, GAME_TICK_LENGTH, GAME_TICK_LENGTH);
    }

    private void gameLoop() {
        ticks++;
        if (ticks % 30 == 0) {
            score++;
            player.decreaseHealth();
        }

        player.walk();
        movedCloserChecker.checkMovedCloser();
        movedCloserChecker1.checkMovedCloser();
        movedCloserChecker2.checkMovedCloser();
        movedCloserChecker3.checkMovedCloser();
        movedCloserChecker4.checkMovedCloser();
        movedCloserChecker5.checkMovedCloser();
        stoodStillChecker.checkStoodStill();

        List<Plant> toRemove = plants.stream()
                .filter(x -> player.collision(x))
                .collect(Collectors.toList());

        toRemove.forEach(x -> player.eatPlant(x));
    }

    public void removePlant(Plant plant) {
        if (plants.contains(plant)) {
            plants.remove(plant);
        }
    }

    public void gameOver() {
        sensorLooper.stop();
        timer.cancel();
        System.out.println("Game over, with score: " + score);
        System.exit(0);
    }

}
