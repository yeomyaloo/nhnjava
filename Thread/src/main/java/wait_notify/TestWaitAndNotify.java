package wait_notify;

import java.util.concurrent.locks.ReentrantLock;

public class TestWaitAndNotify {
    static class RunnableThread implements Runnable{


        private String message;
        private int intervalMs;
        private long startTime;
        private long prviousTime;

        static private final ReentrantLock lock = new ReentrantLock();

        public RunnableThread(String message, int intervalMs) {
            this.message = message;
            this.intervalMs = intervalMs;
            this.startTime = System.currentTimeMillis();
            this.prviousTime = startTime;
        }

        synchronized public void wakeUp(){
            this.notify();
        }


        /**
         * Runnable 객체는 임계 구역 내에서 일정 시간 간격으로 wait()메소드를 호출,
         * 대기 모드로 들어간다. main에서 Runnable 객체를 통해 주기적으로 notify() 메소드를 호출한다.
         * */
        synchronized public void task1() throws InterruptedException{
            System.out.printf("Sleep : %s - %s\n", Thread.currentThread().getName(), this.message);
            Thread.sleep((long)(this.intervalMs));

            this.wait();
            System.out.printf("Wake Up : %s - %s\n", Thread.currentThread().getName(), this.message);

        }


        //start()와 run() 차이뭐야
        @Override
        public void run() {
            this.startTime = System.currentTimeMillis();
            this.prviousTime = startTime;

            System.out.printf("Start : %s - %s \n", Thread.currentThread().getName(), this.message);
            while (true){
                try {
                    this.task1();
                } catch (InterruptedException e) {
                    System.out.println("woke up by an interruption");
                    break;
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        RunnableThread runnableThread = new RunnableThread("one", 1000);
        Thread thread1 = new Thread(runnableThread);
        Thread thread2 = new Thread(runnableThread);
        Thread thread3 = new Thread(runnableThread);

        thread1.start();
        thread2.start();
        thread3.start();

        int i = 0;
        while (true){
            Thread.sleep(1000);
            System.out.println(thread1.getState()+" - "+thread2.getState()+" - "+thread3.getState());

            //main에서 Runnable 객체를 통해 주기적으로 notify() 메소드를 호출
            if(++i % 5 == 0){
                runnableThread.wakeUp();
                i = 0;
            }
        }
    }
}
