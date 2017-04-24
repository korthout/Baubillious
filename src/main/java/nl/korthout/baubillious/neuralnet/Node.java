package nl.korthout.baubillious.neuralnet;

import java.util.ArrayList;
import java.util.List;

public class Node {

    private List<Edge> neighbours;

    public Node() {
        this.neighbours = new ArrayList<>();
    }

    public void addNeighbour(Edge edge) {
        neighbours.add(edge);
    }

    public int numberOfNeighbours() {
        return neighbours.size();
    }
}
