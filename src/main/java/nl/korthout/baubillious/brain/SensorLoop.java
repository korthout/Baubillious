package nl.korthout.baubillious.brain;

public class SensorLoop implements Runnable {

    private final Agent agent;

    public SensorLoop(Agent agent) {
        this.agent = agent;
    }

    @Override
    public void run() {
        while (true) {
            agent.checkSensors();
            if (Thread.currentThread().isInterrupted()) {
                break;
            }
        }
    }

}
