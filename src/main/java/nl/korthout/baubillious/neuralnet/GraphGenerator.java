package nl.korthout.baubillious.neuralnet;

import java.util.List;

import nl.korthout.baubillious.neuralnet.graph.Edge;
import nl.korthout.baubillious.neuralnet.graph.Graph;
import nl.korthout.baubillious.neuralnet.graph.Node;

public class GraphGenerator {

    public static final int DEFAULT_NUMBER_OF_NODES = 1;
    public static final int DEFAULT_MIN_NEIGHBOURS = 1;

    private int numberOfNodes;
    private int minNeighbours;

    public GraphGenerator() {
        numberOfNodes = DEFAULT_NUMBER_OF_NODES;
        minNeighbours = DEFAULT_MIN_NEIGHBOURS;
    }

    public GraphGenerator nodes(int number) {
        this.numberOfNodes = number;
        return this;
    }

    public GraphGenerator minNeighbours(int number) {
        this.minNeighbours = number;
        return this;
    }

    public Graph generate() {
        Graph graph = new Graph();
        createNodes(graph);
        return graph;
    }

    private void createNodes(Graph graph) {
        for (int i = 0; i < numberOfNodes; i++) {
            Node node = new Node();
            createEdgesToRandomExistingNodes(graph, node);
            graph.addNode(node);
        }
    }

    private void createEdgesToRandomExistingNodes(Graph graph, Node node) {
        int numberOfPossibleNeighbours = Math.min(minNeighbours, graph.size());
        List<Node> randomExistingNodes = graph.getRandomNodes(numberOfPossibleNeighbours);
        for (Node randomNode: randomExistingNodes) {
            createEdge(randomNode, node);
        }
    }

    private void createEdge(Node node, Node other) {
        Edge edge = new Edge(node, other);
        other.addNeighbour(edge);
        node.addNeighbour(edge);
    }

}
