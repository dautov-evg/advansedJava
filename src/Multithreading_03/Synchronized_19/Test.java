package Multithreading_03.Synchronized_19;

public class Test {
    private int counter;
    public static void main(String[] args) throws InterruptedException {
        Test test = new Test();
        test.doWork();
    }

    /*
    только один поток получает доступ к телу метода в одно время
     */
    public synchronized void increment() { //синхронизация происходит на объекте, у всех объектов есть монитор,
        // монитор в один момент времени может принадлежать только одному потоку
        counter++;
    }
    public void doWork() throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i<10000;i++)
                    increment();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i<10000;i++)
                    increment();
            }
        });

        thread1.start();
        thread2.start();

        /*
        метод join() заставляет подождать main, пока не выполнятся thread1 и thread2
         */
        thread1.join();
        thread2.join();

        System.out.println(counter);
    }
}
