/**
 *  Использование параметра volatile
 *  (сделать параметр изменяемым для потоков, не кэшируя в каждом ядре)
 */
import java.util.Scanner;

public class Volatile {
    public static void main(String[] args) {
        UsingVolatile newThread = new UsingVolatile();
        newThread.start();
        Scanner scan = new Scanner(System.in);
        scan.nextLine();
        newThread.shutDown();
    }
}

class UsingVolatile extends Thread {
    // running не будет кэшироваться для каждого ядра,
    // обращение к переменной происходит из главной памяти
    private volatile boolean running = true;

    @Override
    public void run() {
        while (running) {
            System.out.println("Hello");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void shutDown() {
        this.running = false;
    }
}
