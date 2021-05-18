import java.util.*;

public class Lists {
    public static void main(String[] args) {
        // Динамический список
        List<String> arrayList = new ArrayList<>();

        // Связный список
        List<String> linkedList = new LinkedList<>();

        // Аналогичен связному списку, но все методы синхронизированы
        List<String> vector = new Vector<>();

        // Last in - First out
        List<String> stack = new Stack<>();

        // Синхронизированный список, все операции будут атомарными
        List<String> syncList = Collections.synchronizedList(new ArrayList<>());


        // Реализация своего динамического массива на основе Linked list
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.add(1);
        myLinkedList.add(2);
        myLinkedList.add(3);
        myLinkedList.add(4);
        myLinkedList.add(10);
        myLinkedList.add(20);
        myLinkedList.add(100);

        System.out.println(myLinkedList);
        System.out.println(myLinkedList.get(4));
        System.out.println(myLinkedList.get(5));
        myLinkedList.remove(2);
        System.out.println(myLinkedList);
        myLinkedList.remove(0);
        System.out.println(myLinkedList);
    }
}

class MyLinkedList {
    Node head;// <---  Узел по умолчанию Null
    int size;

    public void add(int value) {
        Node temp = head;
        if (head == null) {
            this.head = new Node(value);
        } else {                                // [1] > [2] > [3] > [4] > null
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(new Node(value));
        }
        size++;
    }

    public String toString() {
        int currInt = 0;
        Node temp = head;
        int[] arr = new int[size];
        while (temp != null) {
            arr[currInt++] = temp.getValue();
            temp = temp.getNext();
        }
        return Arrays.toString(arr);
    }

    public int get(int index) {
        int curIndx = 0;
        Node temp = head;                            // temp
        while (temp != null) {                       // [1]    [2]    [3]    [4]    [5]    [6]    [7]
            if (curIndx == index) {                  // ci=0                 i=3
                return temp.getValue();
            } else {
                temp = temp.getNext();
                curIndx++;
            }
        }
        throw new IllegalArgumentException();
    }

    public void remove(int Index) {
        int curInd = 0;
        Node temp = head;
        if (Index == 0) {
            head = head.getNext();
            size--;
            return;
        }
        while (temp != null) {
            if (curInd + 1 == Index) {
                temp.setNext(temp.getNext().getNext());
                size--;
                return;// [1] [2] [3] [4] [5] [6]
            } else {
                temp = temp.getNext();
                curInd++;
            }
        }
    }

    private static class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}