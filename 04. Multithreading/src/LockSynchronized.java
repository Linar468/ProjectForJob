import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 *  Использование параметра Lock
 *  (синхронизация данных на конкретном объекте)
 */
public class LockSynchronized {
    public static void main(String[] args) {
        new Worker().main();
    }
}

class Worker {
    Object lock1 = new Object();
    Object lock2 = new Object();
    Random random = new Random();
    private List<Integer> list1 = new ArrayList<>();
    private List<Integer> list2 = new ArrayList<>();

    public void add1() {
        // lock1 - Синхронизация по конкретному объекту
        synchronized (lock1) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list1.add(random.nextInt(100));
        }
    }
    public void add2() {
        synchronized (lock2) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list2.add(random.nextInt(100));
        }
    }
    public void work() {
        for (int i = 0; i < 1000; i++) {
            add1();
            add2();
        }
    }
    public void main() {
        long before = System.currentTimeMillis();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                work();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                work();
            }
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long after = System.currentTimeMillis();
        System.out.println("Time = " + (after - before) + " ms");
        System.out.println("List 1: " + list1.size());
        System.out.println("List 2: " + list2.size());
    }
}
