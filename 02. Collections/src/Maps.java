import com.sun.source.tree.SynchronizedTree;

import java.util.*;

public class Maps {
    public static void main(String[] args) {
        // не гарантирует порядок
        Map<Integer, String> hashMap = new HashMap<>();

        // соблюдается порядок добавления (элементы head, tail)
        Map<Integer, String> linkedHashMap = new LinkedHashMap<>();

        // сортирует по ключу (концепция red-black tree)
        Map<Integer, String> treeMap = new TreeMap<>();

        // hashMap с синхронизированными методами
        Map<String, String> hashTable = new Hashtable<>();

        // synchronizedMap, в параметрах можно указать объект синхронизации
        Map<String, String> synchMap = Collections.synchronizedMap(new HashMap<>());

        // использование navigableMap
        TreeMap treeMap1 = new TreeMap();
        treeMap1.put(1,"a");
        treeMap1.put(2,"b");
        treeMap1.put(3,"c");
        System.out.println(treeMap1.subMap(1,3).firstKey());
        System.out.println(treeMap1.headMap(2));
        System.out.println(treeMap1.tailMap(3));
        System.out.println(treeMap1.headMap(3).lastKey());


        testMap(hashMap);
        System.out.println("-----------------");
        testMap(linkedHashMap);
        System.out.println("-----------------");
        testMap(treeMap);

    }

    public static void testMap(Map<Integer, String> map) {
        map.put(39, "Bob");
        map.put(32, "Ann");
        map.put(356, "Tom");
        map.put(3572, "Kate");
        map.put(0, "Tim");

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
