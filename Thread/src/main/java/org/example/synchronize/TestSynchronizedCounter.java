package org.example.synchronize;

import java.time.LocalDateTime;

public class TestSynchronizedCounter{
    static class SynchronizedCounter {
        private static int count = 0;

        public synchronized void increment() throws InterruptedException {
            System.out.printf("[ %s ] : %s - 들어가기\n", LocalDateTime.now()
                    , Thread.currentThread().getName());

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

        /**해당 생성자를 통해 초기화를 진행하면 새로운 SynchronizedCounter 객체를 사용하게 된다.
         * 이렇게 되면 서로 다른 객체로 synchronized된 메서드를 사용해도 다른 구역으로 인지하게 된다.
         */
         public CountBox(){
            this.counter = new SynchronizedCounter();
        }

        @Override
        public void run() {

             while (true){
                 try {
                     this.counter.increment();
                     Thread.sleep(1000);
                 } catch (InterruptedException e) {
                 }
             }
        }
    }

    public static void main(String[] args) {
        CountBox cb1 = new CountBox();
        CountBox cb2 = new CountBox();

        cb1.start();
        cb2.start();
    }
}
