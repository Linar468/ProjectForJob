/**
 *  Использование интерфейса Callable. Реализован способ возврата какого-либо
 *  значения из метода, при помощи класса Future
 */
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class CallableFuture {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(1);
        Future<Integer> future = es.submit(() -> {
            System.out.println("Starting");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Finished");
            Random random = new Random();
            int randomValue = random.nextInt();
            if (randomValue < 5)
                throw new Exception("Something happen ...  ");
            // От наличия return, Java определяет какой интерфейс реализовать Callable или Runnable
            return random.nextInt(10);
        });

        es.shutdown();
        try {
            int result = future.get(); // get дожидается окончания выполнения потока
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            Throwable ex = e.getCause();
            System.out.println(ex.getMessage());
        }
    }
}

