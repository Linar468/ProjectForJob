/**
 Сортировка коллекций, использование компаратора
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortColection {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("Hey");
        list.add("a");
        list.add("ab");

        // Переопределение метода compare()
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() > o2.length()) {
                    return 1;
                } else if (o1.length() < o2.length()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });

        // Описание паттерна сортировки лямбда функцией
        list.sort((s1, s2) -> {
            if (s1.length() > s2.length()) return -1;
            else if (s1.length() < s2.length()) return 1;
            else return 0;
        });

        // Создание компаратора для передачи в качестве аргумента метода
        Comparator<String> comparator = ((s1, s2) -> {
            if (s1.length() > s2.length()) return 1;
            else if (s1.length() < s2.length()) return -1;
            else return 0;
        });

        System.out.println(list);
        list.sort(comparator);
        System.out.println(list);

        // Бинарный поиск
        Collections.sort(list);
        System.out.println(Collections.binarySearch(list, "Hello"));
    }
}
