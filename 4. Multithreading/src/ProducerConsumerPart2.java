/**
 *  Реализация паттерна "производитель-потребитель"
 *  (один поток заполняет очередь, второй отбирает из неё данные)
 *  При заполнении очереди, или наоборот
 *  когда очередь пустая, происходит приостановка и последующий перезапуск потоков
 *  на основе методов wait() и notify().
 *  Используются не синхронизированные методы offer() и poll(), поэтому реализована синхронизация
 *  на основе lock объектов.
 */
import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerPart2 {
    public static void main(String[] args) throws InterruptedException {
        ProducerAndConsumer pc = new ProducerAndConsumer();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.consume();
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
}
class ProducerAndConsumer{
    private Queue<Integer> queue = new LinkedList<>();
    public final int LIMIT = 10;
    private final Object lock = new Object(); // Все обьъекты синхронизации должны быть константами

    public void produce() throws InterruptedException {
        int value = 0;
        while (true){
            synchronized (lock){
                while (queue.size() == LIMIT){
                    lock.wait();
                }
                queue.offer(value++);
                lock.notify();
            }
        }
    }

    public void consume() throws InterruptedException {
        while(true){
            synchronized (lock){
                while(queue.size() == 0){
                    lock.wait();
                }
                int value = queue.poll();
                System.out.println(value);
                System.out.println("Queue size " + queue.size());
                lock.notify();
            }
            Thread.sleep(1000);
        }
    }
}
