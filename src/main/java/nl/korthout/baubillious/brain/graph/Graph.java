package nl.korthout.baubillious.brain.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Graph {

    private List<Node> nodes;

    public Graph() {
        this.nodes = new ArrayList<>();
    }

    public int size() {
        return nodes.size();
    }

    public void addNode(Node node) {
        this.nodes.add(node);
    }

    /**
     * Returns a list of random nodes from the graph.
     * A best effort is made to return as many nodes as requested.
     * However, there may be fewer nodes in the graph than requested.
     */
    public List<Node> getRandomNodes(int requestedNumber) {
        List<Node> shuffledNodes = new ArrayList<>(nodes);
        Collections.shuffle(shuffledNodes);
        int actualNumberToSelect = Math.min(requestedNumber, shuffledNodes.size());
        return shuffledNodes.subList(0, actualNumberToSelect);
    }

    public List<Node> getNodes() {
        return this.nodes;
    }
}
