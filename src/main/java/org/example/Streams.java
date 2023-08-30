package org.example;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Streams {

    public static void main(String[] args) {
        //distinct using streams
        List<Employee> employees = Arrays.asList(
                new Employee("kumar", 28),
                new Employee("sankar", 26),
                new Employee("sankar", 26)
        );

        //employees.stream().filter(distinctByKey(p -> p.name))
          //      .forEach(e -> System.out.println(e.name));

        secondHighestFromMap();
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

    public static void secondHighestFromMap() {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 10);
        map.put("B", 20);
        map.put("C", 30);
        map.put("D", 20);
        map.put("E", 10);

        //convert to a list and create stream
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        Optional<Map.Entry<String, Integer>> secondHighest = list.stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue())) //sort in descding order
                .skip(1) //skip the highest one
                .findFirst();

        if(secondHighest.isPresent()) {
            Map.Entry<String, Integer> entry = secondHighest.get();
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }




        // Find the second highest value
        Collection<Integer> values = map.values();
        TreeSet<Integer> sortedValues = new TreeSet<>(values);
        Integer secondHighestValue = sortedValues.lower(sortedValues.last());

        // Get entries with the second highest value
        List<Map.Entry<String, Integer>> secondHighestEntries = map.entrySet().stream()
                .filter(entry -> entry.getValue().equals(secondHighestValue))
                .collect(Collectors.toList());

        if (!secondHighestEntries.isEmpty()) {
            System.out.println("Entries with second highest value:");
            for (Map.Entry<String, Integer> entry : secondHighestEntries) {
                System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
            }
        } else {
            System.out.println("No entries with second highest value found.");
        }

    }
}
