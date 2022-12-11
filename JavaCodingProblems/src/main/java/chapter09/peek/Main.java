package chapter09.peek;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<String> list = List.of("Anna", "Bob", "Cristian", "Carmen", "Rick", "Carla");
        List<String> nullList = Arrays.asList("Anna", "Bob", null, "Cristian");

        //useless stack only show NullPointerException without details
        List<String> result = list.stream()
                .filter(s -> s.startsWith("C"))
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("result: " + result);

        //using peek
       /* stream(): Anna
        stream(): Bob
        stream(): null*/
        nullList.stream()
                .peek(p -> System.out.println("\t stream(): " + p))
                .filter(s -> s.startsWith("C"))
                .peek(p -> System.out.println("\t filter(): " + p))
                .map(String::toUpperCase)
                .peek(p -> System.out.println("\t map(): " + p))
                .forEach(System.out::println);

    }
}
