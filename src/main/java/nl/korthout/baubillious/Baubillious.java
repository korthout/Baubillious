package nl.korthout.baubillious;

import nl.korthout.baubillious.neuralnet.GraphGenerator;
import nl.korthout.baubillious.neuralnet.graph.Graph;

public class Baubillious {

    private final Graph graph;

    public static void main(String[] args) {
        new Baubillious();
    }

    public Baubillious() {
        graph = new GraphGenerator()
                .nodes(10000)
                .minNeighbours(2)
                .generate();
    }

}
