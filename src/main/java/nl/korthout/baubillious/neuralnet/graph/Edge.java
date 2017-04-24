package nl.korthout.baubillious.neuralnet.graph;

public class Edge {

    private final Node nodeA;
    private final Node nodeB;

    public Edge(Node nodeA, Node nodeB) {
        this.nodeA = nodeA;
        this.nodeB = nodeB;
    }

}
