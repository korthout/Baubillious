package nl.korthout.baubillious.brain;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class ActuatorTest {

    @Test
    public void act() {
        Actor mockedActor = mock(Actor.class);
        Actuator actuator = new Actuator(mockedActor);
        actuator.activate(5);
        verify(mockedActor).act();
    }

    @Test
    public void dontAct() {
        Actor mockedActor = mock(Actor.class);
        Actuator actuator = new Actuator(mockedActor);
        actuator.activate(0);
        verify(mockedActor, times(0)).act();
    }

}
