package nl.korthout.baubillious.brain;

import com.google.common.base.Preconditions;

import nl.korthout.baubillious.brain.graph.Edge;
import nl.korthout.baubillious.brain.graph.Graph;
import nl.korthout.baubillious.brain.graph.GraphGenerator;
import nl.korthout.baubillious.brain.graph.Node;

import java.util.List;

public class Agent {

    private static final int DEFAULT_NUMBER_OF_NODES = 10000;
    private static final int DEFAULT_MIN_NEIGHBOURS = 2;

    private final List<Sensor> input;
    private final List<Actuator> output;
    private final Graph graph;

    public Agent(List<Sensor> sensors, List<Actuator> actuators) {
        input = Preconditions.checkNotNull(sensors);
        output = Preconditions.checkNotNull(actuators);
        graph = new GraphGenerator()
                .nodes(DEFAULT_NUMBER_OF_NODES)
                .minNeighbours(DEFAULT_MIN_NEIGHBOURS)
                .generate();
        connectIO(sensors, actuators);
    }

    private void connectIO(List<Sensor> sensors, List<Actuator> actuators) {
        final int numberOfSensors = sensors.size();
        final int numberOfActuators = actuators.size();
        final int numberOfInputAndOutputNodesNeeded = numberOfSensors + numberOfActuators;
        List<Node> randomNodes = graph.getRandomNodes(numberOfInputAndOutputNodesNeeded);

        List<Node> sensorNodes = randomNodes.subList(0, numberOfSensors);
        connectSensorsToGraphNodes(sensors, sensorNodes);

        List<Node> actuatorNodes = randomNodes.subList(numberOfSensors, randomNodes.size());
        connectActuatorsToGraphNodes(actuators, actuatorNodes);
    }

    private void connectSensorsToGraphNodes(List<Sensor> sensors, List<Node> nodes) {
        for (int i = 0; i < sensors.size(); i++) {
            Sensor sensor = sensors.get(i);
            Node node = nodes.get(i);
            Edge edge = new Edge(sensor, node);
            sensor.addNeighbour(edge);
            node.addNeighbour(edge);
        }
    }

    private void connectActuatorsToGraphNodes(List<Actuator> actuators, List<Node> nodes) {
        for (int i = 0; i < actuators.size(); i++) {
            Actuator actuator = actuators.get(i);
            Node node = nodes.get(i);
            Edge edge = new Edge(actuator, node);
            actuator.addNeighbour(edge);
            node.addNeighbour(edge);
        }
    }

    public void checkSensors() {
        for (Sensor sensor : input) {
            sensor.sense();
        }
    }

}
