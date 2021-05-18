/**
 *  Semaphore - позволяет разграничить доступ к ресурсу в один момент времени.
 *  В качестве примера используется ситуация с подключением к какому либо серверу.
 *  Было создано 200 потоков (имитируют пользователей) и объект Семафор на 10 разрешений.
 *  Тем самым одновременно будут выполняться только 10 операций
 *  (одновременнных подключений). Метод acquire() - занимает ячейку (создаёт подключение).
 *  Release() - освобождает место для другого пользователя.
 */
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

// Разделить ограниченный ресурс между всеми потоками
public class SemaphoreExample {
    public static void main(String[] args) throws InterruptedException {
        Connection connection = Connection.getConnection();
        ExecutorService es = Executors.newFixedThreadPool(200);
        for (int i = 0; i < 200; i++) {
            es.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        connection.doWorkWithSemaphore();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        es.shutdown();
        es.awaitTermination(1, TimeUnit.DAYS);
    }
}

class Connection {  //Singleton pattern
    private static Connection connection = new Connection();
    private int connectionsCount = 0;
    //Количество разрешений, сколько потоков одновременно может обрабатывать данные
    private Semaphore semaphore = new Semaphore(10);

    private Connection() {
    }

    public static Connection getConnection() {
        return connection;
    }

    public void doWorkWithSemaphore() throws InterruptedException {
        // acquire - начать взаимодействовать с ресурсом
        semaphore.acquire();
        try {
            doWork();
        } finally {
            // release - закончить использовать ресурс (всегда в finally блоке)
            semaphore.release();
        }
    }

    private void doWork() throws InterruptedException {
        synchronized (this) {
            connectionsCount++;
            System.out.println(connectionsCount);
        }
        Thread.sleep(5000);
        synchronized (this) {
            connectionsCount--;
        }
    }
}

