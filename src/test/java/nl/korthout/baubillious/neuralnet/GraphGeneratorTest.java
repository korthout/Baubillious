package nl.korthout.baubillious.neuralnet;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

import org.junit.Test;

public class GraphGeneratorTest {

    @Test
    public void generateSingleNodeGraph() {
        Graph graph = new GraphGenerator().nodes(1).generate();
        assertThat(graph, notNullValue());
        assertThat(graph.size(), is(1));
    }

    @Test
    public void generateTwoNodesGraph() {
        Graph graph = new GraphGenerator().nodes(2).minNeighbours(1).generate();
        assertThat(graph, notNullValue());
        assertThat(graph.size(), is(2));
        assertThat("All Nodes must have at least 1 neighbour",
                graph.getNodes().stream().allMatch(x -> x.numberOfNeighbours() >= 1));
    }

    @Test
    public void generate100NodesGraph() {
        Graph graph = new GraphGenerator().nodes(100).minNeighbours(1).generate();
        assertThat(graph, notNullValue());
        assertThat(graph.size(), is(100));
        assertThat("All Nodes must have at least 1 neighbour",
                graph.getNodes().stream().allMatch(x -> x.numberOfNeighbours() >= 1));
    }

    @Test
    public void generateTenNodesDoubleEdgesGraph() {
        Graph graph = new GraphGenerator().nodes(10).minNeighbours(2).generate();
        assertThat(graph, notNullValue());
        assertThat(graph.size(), is(10));
        assertThat("All Nodes must have at least 2 neighbours",
                graph.getNodes().stream().allMatch(x -> x.numberOfNeighbours() >= 2));
    }

    @Test(timeout = 10000)
    public void generate1000Nodes100EdgesGraph() {
        Graph graph = new GraphGenerator().nodes(1000).minNeighbours(100).generate();
        assertThat(graph, notNullValue());
        assertThat(graph.size(), is(1000));
        assertThat("All Nodes must have at least 100 neighbours",
                graph.getNodes().stream().allMatch(x -> x.numberOfNeighbours() >= 100));
    }
}
