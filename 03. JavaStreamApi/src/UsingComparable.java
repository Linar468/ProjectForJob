/**
 Интерфейс Comparable, методы hashCode(), equals()
 */
import java.util.*;

public class UsingComparable {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        Set<Person> personSet = new TreeSet<>();
        addElem(personList);
        addElem(personSet);
        Collections.sort(personList);
        System.out.println(personList);
        System.out.println(personSet);
    }

    private static void addElem(Collection collection) {
        collection.add(new Person(4, "Bbd"));
        collection.add(new Person(5, "Jackie"));
        collection.add(new Person(3, "Gabriel"));
        collection.add(new Person(2, "Tommy"));
        collection.add(new Person(1, "Tomb"));
    }
}

class Person implements Comparable<Person>{
    private int id;
    private String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
    @Override
    public int compareTo(Person o) {
        if (this.name.length() > o.getName().length()){
            return 1;}
        else if(this.name.length() < o.getName().length()){
            return -1;}
        else{
            return 0;}
    }
}
