package Multithreading_03.CallableAndFuture_30;

import java.util.Random;
import java.util.concurrent.*;

public class Test {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<Integer> future = executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("Starting");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Finished");

                Random random = new Random();
                int randomValue = random.nextInt(10);

                if (randomValue < 5) {
                    throw new Exception("Something bad happened");
                }

                return randomValue;
            }
        });

        executorService.shutdown();

        try {
            int result = future.get(); // get дожидается окончание выполнения потока
            System.out.println(result);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            Throwable ex = e.getCause(); // поймали исключение значение < 5
            System.out.println(ex.getMessage());
        }

    }
}
