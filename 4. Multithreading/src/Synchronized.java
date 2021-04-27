/**
 *  Синхронизация потоков, которые выполняют один и тот же метод
 */

public class Synchronized {
    private int counter;

    public static void main(String[] args) throws InterruptedException {
        Synchronized synchronizedThread = new Synchronized();
        synchronizedThread.doWork();
    }

    // synchronized - В один момент времени доступ к методу будет иметь только один поток
    public synchronized void increment() {
        counter++;
    }

    public void doWork() throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    increment();
                    System.out.println(counter);
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    increment();
                    System.out.println(counter);
                }
            }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(counter);
    }
}
