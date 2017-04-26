package nl.korthout.baubillious.brain;

public class SensorLooper {

    private Thread thread;
    private SensorLoop sensorLoop;

    public SensorLooper(Agent agent) {
        this.thread = null;
        this.sensorLoop = new SensorLoop(agent);
    }

    public void start() {
        thread = new Thread(sensorLoop);
        thread.start();
    }

    public void stop() {
        if (thread != null) {
            thread.interrupt();
            thread = null;
        }
    }

}
