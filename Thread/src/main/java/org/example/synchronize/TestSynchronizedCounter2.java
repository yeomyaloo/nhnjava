package org.example.synchronize;

import java.time.LocalDateTime;

public class TestSynchronizedCounter2 {
    static class SynchronizedCounter {
        private static int count = 0;

        public synchronized void increment() throws InterruptedException {
            System.out.printf("[ %s ] : %s - 들어가기\n", LocalDateTime.now()
                    ,Thread.currentThread().getName());

            this.count++;

            System.out.printf("[ %s ] : %s - count : %d\n", LocalDateTime.now()
                    , Thread.currentThread().getName(), this.count);

            Thread.sleep(1000);

            System.out.printf("[ %s ] : %s - 나오기\n", LocalDateTime.now()
                    , Thread.currentThread().getName());
        }

        public synchronized void decrement() {
            this.count--;
        }

        public synchronized int value() {
            return count;
        }

        public String toString() {
            return String.valueOf(this.count);
        }
    }
    static class CountBox extends Thread{
        SynchronizedCounter counter;

        public CountBox(SynchronizedCounter counter){
            this.counter = counter;
        }

        @Override
        public void run() {
            while (true){
                try {
                    this.counter.increment();
                    sleep(1000);
                } catch (InterruptedException e) {

                }
            }
        }
    }

    public static void main(String[] args) {
        SynchronizedCounter counter = new SynchronizedCounter(); // 얘 한개를 사용해 임계구역으로 설정
        CountBox cb1 = new CountBox(counter);
        CountBox cb2 = new CountBox(counter);

        cb1.start();
        cb2.start();
    }
}
