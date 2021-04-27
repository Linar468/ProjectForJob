/**
 *  CountDownLatch - потокобезопасный обратный счетчик.
 *  Метод await() - ожидает пока счетчик не станет равным нулю
 *  для выполнения дальнейших операций. Countdown() - уменьшает счетчик на единицу.
 */
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchExample {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        ExecutorService es = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 3; i++)
            es.submit(new Proc(i, countDownLatch));
        es.shutdown();
        for (int i = 0; i < 3; i++) {
            Thread.sleep(1000);
            countDownLatch.countDown();
        }
    }
}

class Proc implements Runnable {
    private CountDownLatch countDownLatch;
    private int id;

    public Proc(int id, CountDownLatch countDownLatch) {
        this.id = id;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread with id " + id + " proceed");
    }
}
