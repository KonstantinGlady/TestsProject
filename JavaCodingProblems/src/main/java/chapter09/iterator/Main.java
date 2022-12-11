package chapter09.iterator;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        //infinite loop
        // Stream.iterate(1, x -> x + 1).forEach(System.out::println);

        List<Integer> intsList = IntStream.iterate(1, s -> s + 1)
                .takeWhile(p -> p <= 10)
                .boxed()
                .collect(Collectors.toList());
        intsList.forEach(System.out::print);
        System.out.println();

        //takeWhile
        Set<Integer> setOfInts = new HashSet<>(Arrays.asList(2, 4, 6, 8, 1,20, 9,1));
        List<Integer> listOfLessThen10 = setOfInts.stream()
                .takeWhile(s -> s <= 10)
                .collect(Collectors.toList());
        System.out.println("less then 10");
        listOfLessThen10.forEach(System.out::print);
        System.out.println("//");

        List<Integer> ints = Arrays.asList(1, 2, 5, 7, 9, 12, 15, 32);

        // keep orber by relyin on Collections iterator
        ints.forEach(System.out::print);
        System.out.println();
        //order undefined
        ints.stream().forEach(System.out::print);

        System.out.println();
        ints.parallelStream().forEach(System.out::print);

        System.out.println();
        ints.stream().unordered().forEach(System.out::print);

        System.out.println();
        Stream.iterate(1, s -> s <= 20, s -> s + 1).forEach(System.out::print);

        System.out.println();
        Stream.iterate(1, s -> s + 1).limit(20).forEach(System.out::print);


    }
}
