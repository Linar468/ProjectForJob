/**
 *  Ситуация взаимной блокировки потоков (Deadlock).
 *  В качестве примера используется аналог банковских операций.
 *  Для успешной транзакции, необходимо одновременно синхронизироваться на двух объектах
 *  (в данном случае - 2-х банковских аккаунтах). Если в один момент объекты перехвачены разными потоками,
 *  возникнет взаимная блокировка. Каждый поток будет бесконечно ждать пока освободится другой объект.
 *  Синхронизация в даном случае реализована с помощью класса ReentrantLock. Используется метод tryLock(),
 *  объекта Lock.
 */
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLockExample {
    public static void main(String[] args) throws InterruptedException {
        Runer runer = new Runer();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                runer.firstThread();

            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                runer.secondThread();
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        runer.finished();

    }
}

class Runer {
    private Account account1 = new Account();
    private Account account2 = new Account();
    private Lock lock1 = new ReentrantLock();
    private Lock lock2 = new ReentrantLock();


    private void takeLocks(Lock lock1, Lock lock2) {
        boolean firstLockTaken = false;
        boolean secondLockTaken = false;
        while (true) {
            try {
                // tryLock - попытка забрать lock для синхронизации с потоком
                firstLockTaken = lock1.tryLock();
                secondLockTaken = lock2.tryLock();
            } finally {
                if (firstLockTaken && secondLockTaken) {
                    return;
                }
                // если одновременно не смогли забрать оба объекта lock, необходимо освободить занятый Lock, чтобы другой
                // поток забрал его себе и успешно синхронизировался
                if (firstLockTaken) {
                    lock1.unlock();
                }
                if (secondLockTaken) {
                    lock2.unlock();
                }
            }
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void firstThread() {
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            //synchronized (account1) {
            //    synchronized (account2) {
            //lock1.lock();
            //lock2.lock();
            takeLocks(lock1, lock2);
            try {
                Account.transfer(account1, account2, random.nextInt(100));
            } finally {
                lock1.unlock();
                lock2.unlock();
            }
        }
    }

    public void secondThread() {
        Random random = new Random();
        // DeadLock - Синхронизация в разных порядках, потоки не передают данные друг другу,
        // один объект захвачен одним потоком, другой - другим
        for (int i = 0; i < 10000; i++) {
            takeLocks(lock2, lock1);
            try {
                Account.transfer(account2, account1, random.nextInt(100));
            } finally {
                lock1.unlock();
                lock2.unlock();
            }
        }
    }

    public void finished() {
        System.out.println(account1.getBalance());
        System.out.println(account2.getBalance());
        System.out.println("Total = " + (account1.getBalance() + account2.getBalance()));
    }
}

class Account {
    private int balance = 10000;

    public void deposit(int amount) {
        balance += amount;
    }

    public void withDraw(int amount) {
        balance -= amount;
    }

    public int getBalance() {
        return balance;
    }

    public static void transfer(Account acc1, Account acc2, int amount) {
        acc1.withDraw(amount);
        acc2.deposit(amount);
    }
}
