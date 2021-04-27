/**
 *  Реализация паттерна "производитель-потребитель"
 *  (один поток заполняет очередь, второй отбирает из неё данные)
 *  (при этом используются используются методы put, take), необходимости в реализации
 *  синхронизации нету
 */
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
public class ProducerConsumer {
    private static BlockingQueue<Integer> queue = new ArrayBlockingQueue(10);

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }

    private static void produce() throws InterruptedException {
        Random random = new Random();
        while (true) {
            queue.put(random.nextInt(100));
        }
    }
    private static void consume() throws InterruptedException {
        Random random = new Random();
        while (true) {
            Thread.sleep(100);
            if (random.nextInt(10) == 5) {
                System.out.println(queue.take());
                System.out.println("--------------------------");
                System.out.println("Queue size = " + queue.size());
            }
        }
    }
}
