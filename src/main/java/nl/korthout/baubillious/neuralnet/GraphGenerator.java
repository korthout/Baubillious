package nl.korthout.baubillious.neuralnet;

import java.util.List;

public class GraphGenerator {

    private int nodes;
    private int minNeighbours;

    public GraphGenerator() {
        nodes = 0;
        minNeighbours = 0;
    }

    public GraphGenerator nodes(int number) {
        this.nodes = number;
        return this;
    }

    public GraphGenerator minNeighbours(int number) {
        this.minNeighbours = number;
        return this;
    }

    public Graph generate() {
        Graph graph = new Graph();

        for (int i=0; i<nodes; i++) {
            Node node = new Node();

            List<Node> randomNodes = graph.getRandomNodes(Math.min(minNeighbours, i));
            for (Node randomNode: randomNodes) {
                Edge edge = new Edge(randomNode, node);
                randomNode.addNeighbour(edge);
                node.addNeighbour(edge);
            }

            graph.addNode(node);
        }

        return graph;
    }

}
