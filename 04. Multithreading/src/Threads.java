/**
 *  Пример создания дополнительных потоков
 */
public class Threads {
    public static void main(String[] args) throws InterruptedException {
        MyThread first = new MyThread();
        first.setName("NUMBER_1");
        first.start();

        MyThread second = new MyThread();
        second.setName("NUMBER_2");
        second.start();
    }
}
class MyThread extends Thread{
    public void run(){
        for(int i =0; i<1000; i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Hello from my thread: " + Thread.currentThread().getName() + " " + i);
        }
    }
}