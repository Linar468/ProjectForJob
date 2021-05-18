import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

public class Queues {
    public static void main(String[] args) {
        Person p1 = new Person(1);
        Person p2 = new Person(2);
        Person p3 = new Person(3);
        Person p4 = new Person(4);

        // Обычная очередь (First in - First out)
        Queue <String> linkedList = new LinkedList<>();

        // Сортирует эелементы
        Queue <String> priorityQueue = new PriorityQueue<>();

        // Двунаправленные очереди
        Deque <String> linkedDeque = new LinkedList<>();
        Deque <String> arrayDeque = new ArrayDeque<>();

        // Больший функционал по сравнению с обычным queue
        System.out.println(linkedDeque.offer("111"));
        System.out.println(linkedDeque.offerFirst("222"));
        System.out.println(linkedDeque.getLast());
        System.out.println(linkedDeque.pollFirst());

        // Очередь с блокировкой
        Queue<Person> personQueue = new ArrayBlockingQueue<Person>(3);

        System.out.println(personQueue.offer(p3));
        System.out.println(personQueue.offer(p2));
        System.out.println(personQueue.offer(p4));
        System.out.println(personQueue.offer(p1));

        for (Person person : personQueue) {
            System.out.println(person);
            System.out.println(personQueue.remove());
            System.out.println(personQueue.peek());

        }
    }
}

    class Person {
        private int id;

        public Person(int id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "id=" + id +
                    '}';
        }
    }

