/**
 *  Прерывание потоков, параметр isInterrupted
 */
public class ThreadInterrupt {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                if (Thread.currentThread().isInterrupted()){
                    System.out.println("Thread was Interrupted");
                }
            }
        });
        System.out.println("Thread started");
        t1.start();
        Thread.sleep(1000);
        t1.interrupt();
        t1.join();
        System.out.println("Thread finished");
    }
}
