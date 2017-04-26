package nl.korthout.baubillious.brain;

import nl.korthout.baubillious.brain.graph.Edge;
import nl.korthout.baubillious.brain.graph.Node;

import org.junit.Test;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class SensorTest {

    @Test
    public void makeASensorSense() {
        Stimulable mockedStimulable = mock(Stimulable.class);
        Sensor sensor = new Sensor(mockedStimulable);
        sensor.sense();
        verify(mockedStimulable).isStimulated();
    }

    @Test
    public void sensorActivatesNodeInGraph() {
        Stimulable mockedStimulable = mock(Stimulable.class);
        Sensor sensor = new Sensor(mockedStimulable);
        Node mockedNode = mock(Node.class);
        Edge edge = new Edge(sensor, mockedNode);
        sensor.addNeighbour(edge);
        mockedNode.addNeighbour(edge);
        when(mockedStimulable.isStimulated()).thenReturn(true);
        verify(mockedNode, times(0)).activate(anyInt());
        sensor.sense();
        verify(mockedNode).activate(Sensor.POWER - 1);
    }

}
