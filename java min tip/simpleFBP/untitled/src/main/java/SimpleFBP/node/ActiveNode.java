package SimpleFBP.node;

public class ActiveNode extends Node implements Runnable{

    private Thread thread;
    private boolean stopped;
    private long startTime;
    private long interval;


    public ActiveNode() {
    }

    public ActiveNode(String name) {
        super(name);
    }

    @Override
    public void run() {
        while (true){
            Thread.State state = thread.getState();

            if(state == Thread.State.WAITING || state == Thread.State.TIMED_WAITING ||state==Thread.State.BLOCKED){
                try {
                    thread.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if(state == Thread.State.TERMINATED){
                break;
            }
            if(state == Thread.State.RUNNABLE){
                thread.notify();
            }
            try {
                startTime = System.currentTimeMillis();
                Thread.sleep(this.interval);

            } catch (InterruptedException e) {

            }


        }

        //수행종료

    }


    public boolean isStopped() {
        return stopped;
    }

    public void setStopped(boolean stopped) {
        this.stopped = stopped;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getInterval() {
        return interval;
    }

    public void setInterval(long interval) {
        this.interval = interval;
    }
}
