package StartMultithreading;

public class Test1 {
    public static void main(String[] args) throws InterruptedException {
//        MyThread myThread = new MyThread();
//        myThread.start();
//        MyThread myThread1 = new MyThread();
//        myThread1.start();
        Thread thread = new Thread(new Runner());
        thread.start();
        Thread thread1 = new Thread(new Runner());
        thread1.start();

        System.out.println("Hello main");


    }
}
class Runner implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Hello from MyThread!"+i);
        }
    }
}

class MyThread extends Thread {
    public void run() {
        for (int i = 0; i < 1000; i++) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Hello from MyThread!"+i);
        }
    }
}
