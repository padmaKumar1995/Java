package org.example;

import java.util.Arrays;

public class Streams {

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
}
