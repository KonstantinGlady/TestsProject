package com.gik.testsProject.gik.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    private static class Person {
        enum Position {
            ENGINEER, DIRECTOR, MANAGER;
        }

        private String name;
        private int age;
        private Position position;

        public Person(String name, int age, Position position) {
            this.name = name;
            this.age = age;
            this.position = position;
        }
    }

    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>(Arrays.asList(
                new Person("Ivan", 19, Person.Position.ENGINEER),
                new Person("Maria", 22, Person.Position.MANAGER),
                new Person("Andrey", 33, Person.Position.DIRECTOR),
                new Person("Lary", 23, Person.Position.ENGINEER),
                new Person("Vasiliy", 21, Person.Position.ENGINEER)
        ));

        List<String> engineers = persons.stream()
                .filter(x -> x.position == Person.Position.ENGINEER)
                .sorted((x, y) -> x.age - y.age)
                .map(x -> x.name)
                .collect(Collectors.toList());
        // .forEach(System.out::println);
        engineers.forEach(System.out::println);

        Stream.of(1, 2, 4, 5, 6)
                .filter(x -> x > 3)
                .forEach(System.out::println);

        int n = IntStream.of(1, 3, 4, 7)
                .sum();
        System.out.println(n);

        List<Integer> listMap = Arrays.asList(1, 3, 4, 5);
        listMap.stream()
                .map(x -> x * 10) // function принимаем объект одного типа чтото делаем возвращаем любого
                .limit(2)
                .forEach(System.out::println);

        Stream.of(2, 3, 4, 5).distinct().forEach(System.out::println);// уникальные

        List<Integer> matchList = Arrays.asList(2, 3, 4, 5);
        System.out.println(matchList.stream().anyMatch(x -> x > 3));
        System.out.println(matchList.stream().allMatch(x -> x > 3));


    }
}
