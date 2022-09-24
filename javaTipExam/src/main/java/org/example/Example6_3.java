package org.example;

import java.rmi.NoSuchObjectException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Example6_3 {

    static class Producer implements Runnable{
        Consumer.Market market;
        String fruit;
        long interval;

        public Producer(Consumer.Market market, String fruit, long interval){
            this.market = market;
            this.fruit = fruit;
            this.interval = interval;
        }


        @Override
        public void run() {
            long startTime = System.currentTimeMillis();
            System.out.printf("%s를 시작합니다. \n", Thread.currentThread().getName());
            try{
                while (true){
                    System.out.printf("%s에서 %s를 납품합니다 \n", Thread.currentThread().getName(), this.fruit);
                    this.market.put(this.fruit);
                    Thread.sleep(this.interval - (System.currentTimeMillis() - startTime) % this.interval);
                }
            } catch (InterruptedException e) {
                System.out.printf("%s에 인터럽트가 발생했습니다.\n", Thread.currentThread().getName());
            }
            System.out.printf("%s를 종료합니다. \n", Thread.currentThread().getName());
        }
    }
    static class Consumer implements Runnable {
        Market market;
        String[] fruits;
        long minInterval;
        long maxInterval;

        public Consumer(Market market, String[] fruits, long minInterval, long maxInterval) {
            this.market = market;
            this.fruits = Arrays.copyOf(fruits, this.fruits.length);
            this.minInterval = minInterval;
            this.maxInterval = maxInterval;
        }

        @Override
        public void run() {
            Random random = new Random();
            long StartTime = System.currentTimeMillis();

            System.out.printf("%s를 시작합니다. \n", Thread.currentThread().getName());
            try {
                while (true) {
                    String fruit = this.fruits[random.nextInt(this.fruits.length)];
                    try {
                        System.out.printf("%s가 %s를 구매하길 원합니다.\n", Thread.currentThread().getName(), fruit);
                        this.market.get(fruit);
                        System.out.printf("%s가 %s를 구매하였습니다.\n", Thread.currentThread().getName(), fruit);
                    } catch (NoSuchObjectException e) {
                        System.out.printf("%s가 %s를 구매하길 원합니다.\n", Thread.currentThread().getName(), fruit);
                        this.market.waitingForStock();
                        System.out.printf("%s의 제고가 재입고 되었습니다..\n", Thread.currentThread().getName());
                    }
                    Thread.sleep(this.minInterval + (long) (Math.random() * (this.maxInterval - this.minInterval)));
                }
            } catch (InterruptedException e) {
                System.out.printf("%s에 인터럽트가 발생했습니다.\n", Thread.currentThread().getName());
            }
            System.out.printf("%s를 종료합니다. \n", Thread.currentThread().getName());
        }

        static class Market {
            int size;
            Map<String, Integer> table;
            Lock lock;

            public Market(int size) {
                this.size = size;
                this.table = new HashMap<>();
                this.lock = new ReentrantLock();
            }

            public synchronized void put(String fruit) {
                this.lock.lock();
                int stock = 0;

                if (this.table.containsKey(fruit)) {
                    stock = this.table.get(fruit) + 1;
                    this.table.replace(fruit, stock);
                } else {
                    stock = 1;
                    this.table.replace(fruit, stock);
                }
                System.out.printf("%s의 현재 제고는 %d개 입니다. \n", fruit, stock);
                this.lock.unlock();
                this.notify();
            }

            public synchronized void get(String fruit) throws NoSuchObjectException {
                try {
                    this.lock.lock();
                    if (this.table.containsKey(fruit) && this.table.get(fruit) != 0) {
                        int stock = this.table.get(fruit) - 1;
                        this.table.replace(fruit, stock);
                        System.out.printf("%s의 현재 제고는 %d개 입니다.");
                    } else {
                        throw new NoSuchObjectException(fruit + "은 현재 품절입니다.");
                    }
                } catch (Exception e) {
                    throw e;
                } finally {
                    this.lock.unlock();
                }
            }

            public synchronized void waitingForStock() throws InterruptedException {
                this.wait();
            }

            @Override
            public String toString() {
                StringBuilder line = new StringBuilder();

                for (String fruit : this.table.keySet()) {
                    line.append(fruit + " : " + this.table.get(fruit) + " ");
                }

                return line.toString();
            }
        }

        public static void main(String[] args) throws InterruptedException {
            Market market = new Market(10);
            Thread producer = new Thread(new Producer(market, "apple", 3000));
            Thread consumer = new Thread(new Consumer(market, new String[]{"apple"}, 1000, 4000));

            producer.start();
            consumer.start();

            while (true){
                Thread.sleep(1000);
            }

        }
    }
}
