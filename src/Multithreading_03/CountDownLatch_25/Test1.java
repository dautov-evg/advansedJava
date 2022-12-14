package Multithreading_03.CountDownLatch_25;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test1 {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 3; i++)
            executorService.submit(new Processor1(i, countDownLatch));

        executorService.shutdown();

        for (int i = 0; i < 3; i++) {
            Thread.sleep(500);
            countDownLatch.countDown();
        }

    }
}

class Processor1 implements Runnable {
    private int id;
    private CountDownLatch countDownLatch;

    public Processor1(int id, CountDownLatch countDownLatch) {
        this.id = id;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Thread with id " + id + " proceeded.");
    }
}