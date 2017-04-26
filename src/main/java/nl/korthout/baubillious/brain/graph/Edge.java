package nl.korthout.baubillious.brain.graph;

public class Edge {

    private final Node one;
    private final Node two;
    private int weight;

    public Edge(Node one, Node two) {
        this.one = one;
        this.two = two;
        this.weight = 1;
    }

    public Node getNeighbour(Node current){
        if(!(current.equals(one) || current.equals(two))){
            return null;
        }
        return (current.equals(one)) ? two : one;
    }

    public void increaseWeight() {
        weight++;
    }

    public void decreaseWeight() {
        weight = Math.max(weight - 1, 1);
    }

}
