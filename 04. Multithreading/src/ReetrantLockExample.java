/**
 *  Класс ReentrantLock - инструмент синхронизации потоков
 *  Объект Lock, методы lock() и unlock() - захватить или освободить объект синхронизации
 */
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
// Инструмент синхронизации потоков
public class ReetrantLockExample {
    public static void main(String[] args) throws InterruptedException {
        Task task = new Task();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                task.First();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                task.Second();

            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        task.show();

    }
}
class Task{
    private int counter;
    private Lock lock = new ReentrantLock();

    public  void increment(){
        for (int i =0; i<10000; i++){
            counter++;
        }
    }
    public void First(){
        lock.lock();
        increment();
        lock.unlock();
    }
    public void Second(){
        lock.lock();
        increment();
        lock.unlock();
    }
    public void show(){
        System.out.println(counter);
    }
}
