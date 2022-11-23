package Multithreading_03.ThreadPool_21;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (int i = 1; i <= 10; i++)
            executorService.submit(new Work(i));

        executorService.shutdown();
        System.out.println("All tasks submitted");

        executorService.awaitTermination(1, TimeUnit.MINUTES);
    }
}

class Work implements Runnable {
    private int id;

    public Work(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Work " + id + " was complited");
    }
}