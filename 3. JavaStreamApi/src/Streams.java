/**
 Обработка коллекций. Использование стримов
 */
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.*;

public class Streams {
    public static void main(String[] args) throws IOException {
        List<Employee> emps = List.of(
                new Employee("Michael", "Smith", 243, 43, "CHEF"),
                new Employee("Jane", "Smith", 523, 40, "MANAGER"),
                new Employee("Jury", "Gagarin", 6423, 26, "MANAGER"),
                new Employee("Jack", "London", 5543, 53, "WORKER"),
                new Employee("Eric", "Jackson", 2534, 22, "WORKER")
        );

        // Создание стримов из объектов файловой системы
        Stream<String> lines = Files.lines(Paths.get("some.txt"));
        Stream<Path> list = Files.list(Paths.get("./"));
        Stream<Path> walk = Files.walk(Paths.get("./"), 3);

        // Создание из примитивов
        IntStream intStream = IntStream.of(1, 2, 3, 4);
        DoubleStream doubleStream = DoubleStream.of(1.2, 3.4);
        IntStream range = IntStream.range(10, 100); // 10 .. 99
        IntStream intStream1 = IntStream.rangeClosed(10, 100); // 10 .. 100

        int[] ints = {1, 2, 3, 4};
        IntStream stream = Arrays.stream(ints);

        Stream<String> stringStream = Stream.of("1", "2", "3");
        Stream<? extends Serializable> stream1 = Stream.of(1, "2", "3");

        // Stream builder
        Stream<String> build = Stream.<String>builder()
                .add("Mike")
                .add("joe")
                .build();

        // Стримы из объектов
        Stream<Employee> stream2 = emps.stream();
        Stream<Employee> employeeStream = emps.parallelStream();

        // Преобразования
        Stream<Integer> iterate = Stream.iterate(1950, val -> val + 3);
        Stream<String> concat = Stream.concat(stringStream, build);
        IntStream intStream2 = IntStream.of(100, 200, 300, 400);
        intStream.reduce((left, right) -> left + right).orElse(0);
        IntStream.of(100, 200, 300, 400).average();
        IntStream.of(100, 200, 300, 400).max();
        IntStream.of(100, 200, 300, 400).min();
        IntStream.of(100, 200, 300, 400).sum();
        IntStream.of(100, 200, 300, 400).summaryStatistics();

        // Операции над объектами
        Stream<Employee> empStream = emps.stream();
        empStream.count();
        emps.stream().forEach(employee -> System.out.println(employee.getAge()));
        emps.forEach(employee -> System.out.println(employee.getAge()));
        emps.stream().forEachOrdered(employee -> System.out.println(employee.getAge()));
        emps.stream().collect(Collectors.toList());
        emps.stream().toArray();
        Map<Integer, String> collect = emps.stream().collect(Collectors.toMap(
                Employee::getId,
                emp -> String.format("%s %s", emp.getLastName(), emp.getFirstName())
        ));
        emps.stream().max(Comparator.comparingInt(Employee::getAge));
        emps.stream().findAny();
        emps.stream().findFirst();
        emps.stream().noneMatch(employee -> employee.getAge() > 60); // true
        emps.stream().anyMatch(employee -> employee.getRole() == "CHEF"); // true
        emps.stream().allMatch(employee -> employee.getAge() > 18); // true

        // Трансформация
        LongStream longStream = IntStream.of(100, 200, 300, 400).mapToLong(Long::valueOf);
        IntStream.of(100, 200, 300, 400, 100, 200).distinct(); // 100, 200, 300, 400
        Stream<Employee> employeeStream2 = emps.stream().filter(employee -> employee.getRole() != "CHEF");

        emps.stream()
                .skip(3)
                .limit(5);

        emps.stream()
                .sorted(Comparator.comparingInt(Employee::getAge))
                .peek(emp -> emp.setAge(18))
                .map(emp -> String.format("%s %s", emp.getLastName(), emp.getFirstName()));

        emps.stream().takeWhile(employee -> employee.getAge() > 30).forEach(System.out::println);
        emps.stream().dropWhile(employee -> employee.getAge() > 30).forEach(System.out::println);

        IntStream.of(100, 200, 300, 400)
                .flatMap(value -> IntStream.of(value - 50, value))
                .forEach(System.out::println);

        Stream<Employee> empl = emps.stream()
                .filter(employee ->
                        employee.getAge() <= 30 && employee.getRole() != "WORKER"
                )
                .sorted(Comparator.comparing(Employee::getLastName));

        print(empl);

        Stream<Employee> sorted = emps.stream()
                .filter(employee -> employee.getAge() > 40)
                .sorted((o1, o2) -> o2.getAge() - o1.getAge())
                .limit(4);

        print(sorted);

        IntSummaryStatistics statistics = emps.stream()
                .mapToInt(Employee::getAge)
                .summaryStatistics();

        System.out.println(statistics);
    }

    public static void print(Stream<Employee> stream) {
        stream
                .map(emp -> String.format(
                        "%4d | %-15s %-10s age %s %s",
                        emp.getId(),
                        emp.getLastName(),
                        emp.getFirstName(),
                        emp.getAge(),
                        emp.getRole()
                ))
                .forEach(System.out::println);
    }

    static class Employee {
        private String firstName;
        private String lastName;
        private int id;
        private int age;
        private String role;

        public Employee(String firstName, String lastName, int id, int age, String role) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.id = id;
            this.age = age;
            this.role = role;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }
    }
}

