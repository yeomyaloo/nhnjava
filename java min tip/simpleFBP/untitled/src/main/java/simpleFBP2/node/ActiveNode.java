package simpleFBP2.node;

public class ActiveNode extends Node implements Runnable{
    private Thread thread;
    private boolean stopped;
    private long startTime;
    private long interval;

    public ActiveNode() {
        this.stopped = false;

    }

    @Override
    public void run() {
        thread = new Thread();
        thread.start();
        startTime = System.currentTimeMillis();
        while (true){
            Thread.State state = thread.getState();

            if (state == Thread.State.BLOCKED || state == Thread.State.TIMED_WAITING || state == Thread.State.WAITING){
                try {
                    thread.wait();
                } catch (InterruptedException e) {

                }

            }
            else if (state == Thread.State.TERMINATED){
                break;

            } else if (state == Thread.State.RUNNABLE) {
                thread.notify();
            }
            try{
                thread.sleep(this.interval);
            } catch (InterruptedException e) {

            }
        }
    }


    public boolean isStopped() {
        return stopped;
    }

    public void setStopped(boolean stopped) {
        this.stopped = stopped;
    }

    public long getInterval() {
        return interval;
    }

    public void setInterval(long interval) {
        this.interval = interval;
    }

    public long getStartTime() {
        return startTime;
    }
}
