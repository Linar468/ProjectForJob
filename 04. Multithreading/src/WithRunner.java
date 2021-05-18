/**
 *  использование интерфейса Runnable
 */
public class WithRunner {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runner());
        thread.start();
    }
}

class Runner implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Hello from Runner");
        }
    }
}
