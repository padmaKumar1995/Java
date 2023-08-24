package org.example;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

public class Streams {

    public static void main(String[] args) {
        //distinct using streams
        List<Employee> employees = Arrays.asList(
                new Employee("kumar", 28),
                new Employee("sankar", 26),
                new Employee("sankar", 26)
        );

        employees.stream().filter(distinctByKey(p -> p.name))
                .forEach(e -> System.out.println(e.name));
    }

    public void testStream() {
        var intList = Arrays.asList(1, 2, 3, 7, 9, 11, 123, 5, 6, 7);

        intList.stream()
                .filter(i -> i > 10)
                .forEach(System.out::println);

        intList.stream()
                .map(Math::sqrt)
                .forEach(System.out::println);

        var sum = intList.stream()
                .reduce(Integer::sum);

        System.out.println(sum.get());

        //uses threads to execute
        intList.stream().parallel().forEach(System.out::println);
    }

    public static <T> Predicate<T> distinctByKey(Function<T, Object> keyExtractor) {
        Map<Object, Boolean> map = new ConcurrentHashMap<>();
        return t -> map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }

    public static class Employee {
        String name;
        int age;

        public Employee(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }
}
