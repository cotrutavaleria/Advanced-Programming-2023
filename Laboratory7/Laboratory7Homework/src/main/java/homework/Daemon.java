package homework;

public class Daemon extends Thread {
    private final Exploration explore;
    private long start;

    public Daemon(Exploration explore, long time) {
        this.explore = explore;
        this.start = time;
    }

    @Override
    public void run() {
        long elapsedTime = 0;
        while (explore.getFlag() == 0) {
            long end = System.currentTimeMillis();
            elapsedTime = end - start;
            if (elapsedTime > 100_000) {
                explore.setFlag(1);
                synchronized (explore) {
                    explore.notifyAll();
                }
                Thread.interrupted();
            }
            synchronized (explore) {
                if (explore.getExtractedTokenListSize() == Math.pow(explore.getNumber(),3)) {
                    explore.setFlag(1);
                }
            }
        }
        System.out.println("Timp : " + elapsedTime + " milisecunde");
        explore.displayTokenNumber();
    }
}