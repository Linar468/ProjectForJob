/**
 *  Синхронизированная приостановка и последующий перезапуск потоков с ожиданием
 *  на основе методов wait() и notify()
 */
import java.util.Scanner;

public class WaitNotify {
    public static void main(String[] args) throws InterruptedException {
        Object obj = new Object();
        WaitAndNotify wn = new WaitAndNotify();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    wn.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    wn.consume();
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
class WaitAndNotify {
    public void produce() throws InterruptedException {
        synchronized (this) {
            System.out.println("Producer thread started");
            wait();   //this.wait    1)Отдает Intrinsic lock 2)Ждет пока будет вызван метод Notify
            wait(1000);
            System.out.println("Producer thread resumed...");
        }

    }
    public void consume() throws InterruptedException {
        Thread.sleep(2000);
        Scanner scan = new Scanner(System.in);
        synchronized (this) {
            System.out.println("Waiting for returned Key Pressed");
            scan.nextLine();
            notify();
            Thread.sleep(5000);
        }
    }
}
