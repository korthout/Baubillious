package nl.korthout.baubillious.neuralnet;

/**
 * Created by nicokorthout on 24/04/2017.
 */
public class Edge {

    private final Node nodeA;
    private final Node nodeB;

    public Edge(Node nodeA, Node nodeB) {
        this.nodeA = nodeA;
        this.nodeB = nodeB;
    }

}
