package simpleFBP2.node;

public class RNGNode2 extends Thread{
    private int interval;

    public RNGNode2(int interval) {
        this.interval = interval;
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(this.interval);
            } catch (InterruptedException e) {



            }
        }
    }
}
