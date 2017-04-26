package nl.korthout.baubillious.brain.graph;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;

public class NodeTest {

    @Test
    public void createNode() {
        Node node = new Node();
        assertThat(node.numberOfNeighbours(), is(0));
        assertThat(node.isActivated(), is(false));
    }

    @Test
    public void twoNodesAsNeighbours() {
        Node one = new Node();
        Node two = new Node();
        Edge edge = new Edge(one, two);
        one.addNeighbour(edge);
        two.addNeighbour(edge);
        assertThat(one.numberOfNeighbours(), is(1));
        assertThat(two.numberOfNeighbours(), is(1));
    }

    @Test
    public void TenNodesAsNeighbours() {
        Node nodeWithTenNeighbours = new Node();
        for (int i = 0; i < 10; i++) {
            Node other = new Node();
            Edge edge = new Edge(nodeWithTenNeighbours, other);
            nodeWithTenNeighbours.addNeighbour(edge);
            other.addNeighbour(edge);
        }
        assertThat(nodeWithTenNeighbours.numberOfNeighbours(), is(10));
    }

    @Test
    public void activateNode() {
        Node one = new Node();
        Node two = mock(Node.class);
        Edge edge = new Edge(one, two);
        one.addNeighbour(edge);
        assertThat(one.isActivated(), is(false));

        one.activate(2);
        verify(two).activate(1);
        assertThat(one.isActivated(), is(false));
    }

    @Test
    public void activateNodeChain() {
        Node one = new Node();
        Node two = new Node();
        Node three = new Node();
        Node four = new Node();
        Node five = mock(Node.class);
        Edge edge1 = new Edge(one, two);
        Edge edge2 = new Edge(two, three);
        Edge edge3 = new Edge(three, four);
        Edge edge4 = new Edge(four, five);
        one.addNeighbour(edge1);
        two.addNeighbour(edge2);
        three.addNeighbour(edge3);
        four.addNeighbour(edge4);

        one.activate(10);
        verify(five).activate(6);
    }

    @Test
    public void activateNodeChainTooLessPower() {
        Node one = new Node();
        Node two = new Node();
        Node three = new Node();
        Node four = new Node();
        Node five = mock(Node.class);
        Edge edge1 = new Edge(one, two);
        Edge edge2 = new Edge(two, three);
        Edge edge3 = new Edge(three, four);
        Edge edge4 = new Edge(four, five);
        one.addNeighbour(edge1);
        two.addNeighbour(edge2);
        three.addNeighbour(edge3);
        four.addNeighbour(edge4);

        one.activate(3);
        verify(five, times(0)).activate(anyInt());
    }

}
