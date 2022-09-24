package threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Example8_1 {

    //Runnable 객체
    static class Task implements Runnable{
        private String name;
        private long interval;

        public Task(String name, long interval) {
            this.name = name;
            this.interval = interval;
        }

        public String getName() {
            return name;
        }

        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getState() + " : " +this.getName() + "(start)");
                for(int i = 0; i <100 ; i++){
                    Thread.sleep(this.interval);
                    System.out.println(Thread.currentThread().getName());
                }
                System.out.println(Thread.currentThread().getState() + " : " +this.getName() + "(start)");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        //thread Pool 5개 짜리를 만듬
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (int i = 0; i< 10; i++){
            Runnable task = new Task(String.format("Task%02d", i), 2000);
            executorService.execute(task);
        }
        executorService.shutdown();
        while(!executorService.isTerminated()){}

        System.out.println("Finished all thread");
    }
}
