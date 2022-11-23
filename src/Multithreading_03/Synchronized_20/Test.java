package Multithreading_03.Synchronized_20;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Test {
    private int counter;

    public static void main(String[] args) {
        new Worker().main();
    }
}

class Worker {
    Random random = new Random();

    Object lock1 = new Object();
    Object lock2 = new Object();

    private List<Integer> list1 = new ArrayList<>();
    private List<Integer> list2 = new ArrayList<>();

    public void addToList1() {
        synchronized (lock1) { //можно любой другой объект, lok1 для наглядности, например list1
            try {
                Thread.sleep(1); //для наглядной разницы во времени
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            list1.add(random.nextInt(100));
        }
    }

    public void addToList2() {
        synchronized (lock2) { //можно любой другой объект, lok2 для наглядности, например list1
            try {
                Thread.sleep(1); //для наглядной разницы во времени
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            list2.add(random.nextInt(100));
        }
    }

    public void work() {
        for (int i=0;i<1000;i++) {
            addToList1();
            addToList2();
        }
    }

    public void main() {
        long before = System.currentTimeMillis();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                work();
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                work();
            }
        });
        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        long after = System.currentTimeMillis();
        System.out.println("Program took: " + (after - before) + " ms to run");
        System.out.println("List1: " + list1.size() + list1);
        System.out.println("List2: " + list2.size() + list2);
    }
}