import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Sets {
    public static void main(String[] args) {
        Set<String> hashSet = new HashSet<>(); // без порядка
        Set<String> treeSet = new TreeSet<>(); // отсортировано
        Set<String> linkedHashSet = new LinkedHashSet<>(); // сохраняет порядок добавления

        hashSet.add("Mike");
        hashSet.add("Tom");
        hashSet.add("Tim");
        hashSet.add("Bob");
        hashSet.add("Ann");
        hashSet.add("Tom");
        hashSet.add("Tom");

        for (String name : hashSet) {
            System.out.println(name);
            System.out.println(hashSet.contains("Tom"));
            System.out.println(hashSet.isEmpty());
        }

        System.out.println(hashSet);
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        set1.add(0);
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set1.add(4);
        set1.add(5);

        set2.add(2);
        set2.add(3);
        set2.add(4);
        set2.add(5);
        set2.add(6);
        set2.add(7);

        //обьединение
        Set<Integer> union = new HashSet<>(set1); // содержит все элементы set1
        union.addAll(set2);
        System.out.println(union);

        // пересечение
        Set<Integer> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);
        System.out.println(intersection);

        // разность
        Set<Integer> difference = new HashSet<>(set1);
        difference.removeAll(set2);
        System.out.println(difference);
    }
}
