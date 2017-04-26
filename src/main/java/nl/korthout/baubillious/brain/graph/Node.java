package nl.korthout.baubillious.brain.graph;

import java.util.ArrayList;
import java.util.List;

public class Node {

    private List<Edge> neighbours;
    private boolean activated;

    public Node() {
        this.neighbours = new ArrayList<>();
        this.activated = false;
    }

    public void addNeighbour(Edge edge) {
        neighbours.add(edge);
    }

    public int numberOfNeighbours() {
        return neighbours.size();
    }

    public void activate(int power) {
        if (power > 0) {
            activated = true;
            activateIdleNeighbours(power - 1);
            activated = false;
        }
    }

    private void activateIdleNeighbours(int power) {
        for (Edge edge : neighbours) {
            Node neighbour = edge.getNeighbour(this);
            activateIdleNeighbour(power, neighbour);
        }
    }

    private void activateIdleNeighbour(int power, Node neighbour) {
        if (!neighbour.isActivated()) {
            neighbour.activate(power);
        }
    }

    protected boolean isActivated() {
        return activated;
    }
}
