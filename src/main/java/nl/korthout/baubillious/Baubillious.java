package nl.korthout.baubillious;

import nl.korthout.baubillious.brain.Actuator;
import nl.korthout.baubillious.brain.Agent;
import nl.korthout.baubillious.brain.Sensor;
import nl.korthout.baubillious.brain.SensorLooper;

import java.util.ArrayList;
import java.util.List;

public class Baubillious {

    public static void main(String[] args) {
        new Baubillious();
    }

    public Baubillious() {
        List<Sensor> sensors = new ArrayList<>();
        List<Actuator> actuators = new ArrayList<>();
        Agent agent = new Agent(sensors, actuators);
        SensorLooper sensorLooper = new SensorLooper(agent);
        sensorLooper.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sensorLooper.stop();
    }

}
