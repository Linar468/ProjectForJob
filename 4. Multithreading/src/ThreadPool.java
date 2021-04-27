/**
 *  Создание нескольких потоков с помощью класса ThreadPool.
 *  "Исполнитель задач" - ExecutorService
 *  Назначить задачи и запустить их выполнение с помощью методов submit() и
 *  shutdown(). А также ожидание выполнения всех задач с помощью метода awaitTermination()
 */
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPool {
    public static void main(String[] args) throws InterruptedException {
        // Пул потоков - в данном случае все задачи будут выполнены между 3-мя исполнителями
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 5; i++)
            // submit - заполнение процессами, задачами
            executorService.submit(new Work(i));
        // приступить к выполнению, аналог start
        executorService.shutdown();
        System.out.println("All tasks submited");
        // await - ожидание пока выполнится процесс (1 день)
        executorService.awaitTermination(1, TimeUnit.DAYS);
    }
}

class Work implements Runnable {
    private int Id;

    public Work(int Id) {
        this.Id = Id;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Work " + Id + " was completed");
    }
}
