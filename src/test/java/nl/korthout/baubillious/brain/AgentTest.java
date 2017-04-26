package nl.korthout.baubillious.brain;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class AgentTest {

    @Test(expected = NullPointerException.class)
    public void createAgentNullIO() {
        new Agent(null, null);
    }

    @Test
    public void createAgentWithoutIO() {
        List<Actuator> actuators = new ArrayList<>();
        List<Sensor> sensors = new ArrayList<>();
        Agent agent = new Agent(sensors, actuators);
        agent.checkSensors();
    }

}
